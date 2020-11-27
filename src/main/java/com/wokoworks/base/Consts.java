package com.wokoworks.base;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 飞
 * @Date: 2020/11/25 15:27
 */
public class Consts {

    public static final String TOKEN = "login_token";

    public static final Map<String, Integer> LOGIN_SESSION = new ConcurrentHashMap<>();
}
