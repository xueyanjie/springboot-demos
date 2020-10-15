package com.demo.thymeleafdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @RequestMapping("/hello")
    public String hello(ModelMap map) {
        map.addAttribute("name", "野猪先生XYJ");
        return "demo";
    }

}
