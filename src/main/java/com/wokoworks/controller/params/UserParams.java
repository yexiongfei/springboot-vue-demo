package com.wokoworks.controller.params;

import lombok.Data;

/**
 * @Author: 飞
 * @Date: 2020/11/25 14:50
 */
public class UserParams {

    @Data
    public static class LoginParams {
        private String username;
        private String password;
    }

}

