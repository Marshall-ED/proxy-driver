package org.example.proxy.security.config;

import org.example.proxy.security.custom.CustomMd5PasswordEncoder;
import org.example.proxy.security.fillter.TokenAuthenticationFilter;
import org.example.proxy.security.fillter.TokenLoginFilter;
import org.example.proxy.system.client.SysLoginLogFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author Marshall
 * @Date 2025/2/12 16:46
 * @Description:
 */
@Configuration
@EnableWebSecurity
@EnableWebSecurity(securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private CustomMd5PasswordEncoder customMd5PasswordEncoder;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SysLoginLogFeignClient sysLoginLogFeignClient;

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        // Create a user authentication provider
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        // Set the user details service, which can retrieve user information from the database, cache, or configuration files
        authProvider.setUserDetailsService(userDetailsService);
        // Set the password encoder; we need to know the encoding used to attempt to authenticate the user
        authProvider.setPasswordEncoder(customMd5PasswordEncoder);
        return authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF (Cross-Site Request Forgery) protection
                .csrf()
                .disable()
                // Configure request authorization rules
                .authorizeHttpRequests()
                // Whitelist for Swagger-related paths
                .requestMatchers("/favicon.ico", "/swagger-resources/**", "/webjars/**", "/v3/**", "/doc.html").permitAll()
                // Whitelist for user login-related endpoints
                .requestMatchers("/securityLogin/login").permitAll()
                // All other requests require authentication
                .anyRequest().authenticated()
                .and()
                // Disable session management
                .sessionManagement()
                // Use stateless session management (do not use session to cache data)
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // Add authentication provider
                .and()
                // TODO Add authentication provider
                .authenticationProvider(authenticationProvider())
                // Add token authentication filter before the UsernamePasswordAuthenticationFilter
                .addFilterBefore(new TokenAuthenticationFilter(redisTemplate), UsernamePasswordAuthenticationFilter.class)
                // Add custom token login filter
                .addFilter(new TokenLoginFilter(authenticationManager(authenticationConfiguration), redisTemplate, sysLoginLogFeignClient));

        return http.build();
    }
}
