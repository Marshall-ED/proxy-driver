package org.example.proxy.security.fillter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.proxy.model.entity.system.SysLoginLog;
import org.example.proxy.model.vo.system.LoginVo;
import org.example.proxy.security.custom.CustomUser;
import org.example.proxy.common.result.Result;
import org.example.proxy.common.result.ResultCodeEnum;
import org.example.proxy.common.util.IpUtil;
import org.example.proxy.common.util.ResponseUtil;
import org.example.proxy.system.client.SysLoginLogFeignClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * Login Filter, extending UsernamePasswordAuthenticationFilter, to validate username and password for login.
 * </p>
 */
public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {

    private RedisTemplate redisTemplate;
    private SysLoginLogFeignClient sysLoginLogFeignClient;

    private String ADMIN_LOGIN_KEY_PREFIX = "admin:login:";
    private int ADMIN_LOGIN_KEY_TIMEOUT = 60 * 60 * 24 * 100;

    public TokenLoginFilter(AuthenticationManager authenticationManager, RedisTemplate redisTemplate, SysLoginLogFeignClient sysLoginLogFeignClient) {
        this.setAuthenticationManager(authenticationManager);
        this.setPostOnly(false);
        // Specify the login endpoint and submission method, can be any path
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/securityLogin/login", "POST"));
        this.redisTemplate = redisTemplate;
        this.sysLoginLogFeignClient = sysLoginLogFeignClient;
    }

    /**
     * Authentication attempt
     * @param req
     * @param res
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        try {
            LoginVo loginVo = new ObjectMapper().readValue(req.getInputStream(), LoginVo.class);

            Authentication authenticationToken = new UsernamePasswordAuthenticationToken(loginVo.getUsername(), loginVo.getPassword());
            return this.getAuthenticationManager().authenticate(authenticationToken);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Successful authentication
     * @param request
     * @param response
     * @param chain
     * @param auth
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        CustomUser customUser = (CustomUser) auth.getPrincipal();
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        redisTemplate.opsForValue().set(ADMIN_LOGIN_KEY_PREFIX + token, customUser.getSysUser(), ADMIN_LOGIN_KEY_TIMEOUT, TimeUnit.SECONDS);

        // Save authority data
        //redisTemplate.boundHashOps("admin:auth").put(customUser.getUsername(), customUser.getAuthorities());

        // Record log
        SysLoginLog sysLoginLog = new SysLoginLog();
        sysLoginLog.setUsername(customUser.getUsername());
        sysLoginLog.setStatus(1);
        sysLoginLog.setIpaddr(IpUtil.getIpAddress(request));
        sysLoginLog.setMsg("Login successful");
        sysLoginLogFeignClient.recordLoginLog(sysLoginLog);

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        ResponseUtil.out(response, Result.ok(map));
    }

    /**
     * Unsuccessful authentication
     * @param request
     * @param response
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException e) throws IOException, ServletException {
        if (e.getCause() instanceof RuntimeException) {
            ResponseUtil.out(response, Result.build(null, 204, e.getMessage()));
        } else {
            ResponseUtil.out(response, Result.build(null, ResultCodeEnum.LOGIN_MOBLE_ERROR));
        }
    }
}