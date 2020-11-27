package com.wokoworks.controller;

import com.wokoworks.base.Consts;
import com.wokoworks.base.Resp;
import com.wokoworks.controller.params.UserParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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
            int userId = 1;
            request.getSession().setAttribute(Consts.TOKEN, userId);
            return Resp.ok(null);
        }
        return Resp.reject("账户或者密码错误");
    }
}
