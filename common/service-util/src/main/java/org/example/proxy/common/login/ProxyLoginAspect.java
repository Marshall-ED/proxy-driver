package org.example.proxy.common.login;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.proxy.common.constant.RedisConstant;
import org.example.proxy.common.exception.ProxyException;
import org.example.proxy.common.result.ResultCodeEnum;
import org.example.proxy.common.util.AuthContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Author Marshall
 * @Date 2025/2/12 16:39
 * @Description:
 */
@Component
@Aspect
public class ProxyLoginAspect {
    @Autowired
    private RedisTemplate redisTemplate;

    // Around advice for login check
    // Pointcut expression: Specifies which methods to enhance based on certain rules
    @Around("execution(* org.example.*.controller.*.*(..)) && @annotation(org.example.proxy.common.login.ProxyLogin)")
    public Object login(ProceedingJoinPoint proceedingJoinPoint, ProxyLogin proxyLogin) throws Throwable {

        // 1. Get the request object
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) attributes;
        HttpServletRequest request = sra.getRequest();

        // 2. Get the token from the request header
        String token = request.getHeader("token");

        // 3. Check if the token is empty; if so, return a login prompt
        if (!StringUtils.hasText(token)) {
            throw new ProxyException(ResultCodeEnum.LOGIN_AUTH);
        }

        // 4. If the token is not empty, query Redis
        String customerId = (String) redisTemplate.opsForValue()
                .get(RedisConstant.USER_LOGIN_KEY_PREFIX + token);

        // 5. Query Redis for the corresponding user ID and store it in ThreadLocal
        if (StringUtils.hasText(customerId)) {
            AuthContextHolder.setUserId(Long.parseLong(customerId));
        }
        //6 Process business method
        return proceedingJoinPoint.proceed();
    }
}