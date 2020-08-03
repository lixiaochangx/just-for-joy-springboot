package com.xc.justforjoy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lxcecho
 * @since 2020/8/3
 */
@Controller
public class HelloController {
    @RequestMapping("/abc")
    public String hello(Model model){
        model.addAttribute("msg","你好");
        return "success";
    }
}
