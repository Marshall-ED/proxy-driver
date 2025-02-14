package org.example.proxy.security.fillter;

import com.alibaba.fastjson.JSON;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.proxy.common.result.Result;
import org.example.proxy.common.result.ResultCodeEnum;
import org.example.proxy.common.util.AuthContextHolder;
import org.example.proxy.common.util.ResponseUtil;
import org.example.proxy.model.entity.system.SysUser;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * Authentication Filter
 * </p>
 */
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private RedisTemplate redisTemplate;

    private String ADMIN_LOGIN_KEY_PREFIX = "admin:login:";
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public TokenAuthenticationFilter(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Allow requests to the login endpoint or non-admin paths directly
        String uri = request.getRequestURI();
        if (antPathMatcher.match("/securityLogin/login", uri) ||
                antPathMatcher.match("/swagger-resources/**", uri) ||
                antPathMatcher.match("/webjars/**", uri) ||
                antPathMatcher.match("/v3/**", uri) ||
                antPathMatcher.match("/doc.html", uri) ||
                antPathMatcher.match("/favicon.ico", uri)) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        } else {
            ResponseUtil.out(response, Result.build(null, ResultCodeEnum.PERMISSION));
        }
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        // Token is placed in the header
        String token = request.getHeader("token");
        logger.info("token:" + token);
        if (StringUtils.hasText(token)) {
            SysUser sysUser = (SysUser) redisTemplate.opsForValue().get(ADMIN_LOGIN_KEY_PREFIX + token);
            logger.info("sysUser:" + JSON.toJSONString(sysUser));
            if (sysUser != null) {
                AuthContextHolder.setUserId(sysUser.getId());

                if (sysUser.getUserPermsList() != null && sysUser.getUserPermsList().size() > 0) {
                    List<SimpleGrantedAuthority> authorities = sysUser.getUserPermsList().stream()
                            .filter(code -> StringUtils.hasText(code.trim()))
                            .map(code -> new SimpleGrantedAuthority(code.trim()))
                            .collect(Collectors.toList());
                    return new UsernamePasswordAuthenticationToken(sysUser.getUsername(), null, authorities);
                } else {
                    return new UsernamePasswordAuthenticationToken(sysUser.getUsername(), null, new ArrayList<>());
                }
            }
        }
        return null;
    }
}