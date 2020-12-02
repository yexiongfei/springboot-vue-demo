package com.wokoworks.interceptor;

import com.alibaba.fastjson.JSON;
import com.wokoworks.base.Consts;
import com.wokoworks.base.Resp;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author: 飞
 * @Date: 2020/11/25 14:05
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String cookieValue = request.getHeader(Consts.TOKEN);
        /**
         * 找不到登录token,未登录
         */
        if (Strings.isEmpty(cookieValue)) {
            loginFail(response);
            return false;
        }

        /**
         * 登录token错误,未登录
         */
        Integer userId = Consts.LOGIN_SESSION.get(cookieValue);
        if (userId == null) {
            loginFail(response);
            return false;
        }
        //方便loginHolder内的静态方法拿到用户id
        request.setAttribute("userId", userId);
        return true;
    }

    public void loginFail(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (OutputStream os = response.getOutputStream()) {
            byte[] jsonBytes = JSON.toJSONBytes(Resp.notLogin());
            os.write(jsonBytes);
        }
    }

  



}
