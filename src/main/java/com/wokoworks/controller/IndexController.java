package com.wokoworks.controller;

import com.wokoworks.base.Consts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 飞
 * @Date: 2020/11/25 14:40
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model, HttpServletRequest request) {

        //这里可以改成分布式session
        Object userId = request.getSession().getAttribute(Consts.TOKEN);

        model.addAttribute("isLogin", userId != null);
        model.addAttribute("baseUrl", "------------------");
        return "index";
    }


    
}
