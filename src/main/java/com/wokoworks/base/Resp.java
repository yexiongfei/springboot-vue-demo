package com.wokoworks.base;

import lombok.Data;

/**
 * @Author: 飞
 * @Date: 2020/11/25 11:59
 */
@Data
public class Resp {
    private int code;
    private String msg;
    private Object data;

    public static Resp ok(Object data) {
        Resp resp = new Resp();
        resp.setCode(200);
        resp.setMsg("success");
        resp.setData(data);
        return resp;
    }

    public static Resp reject(String msg) {
        Resp resp = new Resp();
        resp.setCode(400);
        resp.setMsg(msg);
        resp.setData(null);
        return resp;
    }

    public static Resp error(String msg) {
        Resp resp = new Resp();
        resp.setCode(500);
        resp.setMsg(msg);
        resp.setData(null);
        return resp;
    }

    public static Resp notLogin() {
        Resp resp = new Resp();
        resp.setCode(300);
        resp.setMsg("not login");
        resp.setData(null);
        return resp;
    }


}
