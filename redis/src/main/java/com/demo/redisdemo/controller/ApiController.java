package com.demo.redisdemo.controller;

import com.demo.redisdemo.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class ApiController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("set")
    public String setInfo() {
        boolean res = redisUtil.set("test", "Hello redis !");
        redisUtil.expire("test", 86400);
        return String.valueOf(res);
    }

    @RequestMapping("get")
    public String getInfo() {
        String res = redisUtil.get("test").toString();
        long expire = redisUtil.getExpire("test");
        return res + "," + expire;
    }

}
