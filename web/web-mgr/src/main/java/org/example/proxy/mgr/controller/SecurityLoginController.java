package org.example.proxy.mgr.controller;

import com.alibaba.fastjson.JSON;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.proxy.common.result.Result;
import org.example.proxy.common.util.AuthContextHolder;
import org.example.proxy.model.form.system.LoginForm;
import org.example.proxy.system.client.SecurityLoginFeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@Tag(name = "security登录管理")
@RestController
@RequestMapping(value="/securityLogin")
@SuppressWarnings({"unchecked", "rawtypes"})
public class SecurityLoginController {

	@Resource
	private SecurityLoginFeignClient securityLoginFeignClient;

    @Operation(summary = "模拟登录")
    @PostMapping("login")
    public Result login(@RequestBody LoginForm loginForm) {
        log.info(JSON.toJSONString(loginForm));
        return Result.ok();
    }

    @Operation(summary = "获取用户信息")
    @GetMapping("getUserInfo")
    public Result<Map<String, Object>> getUserInfo() {
        Long userId = AuthContextHolder.getUserId();
        Map<String, Object> map = securityLoginFeignClient.getUserInfo(userId).getData();
        return Result.ok(map);
    }
}

