package com.wokoworks.controller;

import com.wokoworks.base.Consts;
import com.wokoworks.base.Resp;
import com.wokoworks.controller.params.UserParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 飞
 * @Date: 2020/11/25 11:59
 */
@RequestMapping("/api/user")
@RestController
public class UserController {

    @PostMapping("/login")
    public Resp login(@RequestBody  UserParams.LoginParams loginParams, HttpServletRequest request, HttpServletResponse response) {
        String username = loginParams.getUsername();
        String password = loginParams.getPassword();
        if (username.equals("root") && password.equals("123456")) {
            String token = UUID.randomUUID().toString();
            Consts.LOGIN_SESSION.put(token, 1);
            return Resp.ok(token);
        }
        return Resp.reject("账户或者密码错误");
    }
}
