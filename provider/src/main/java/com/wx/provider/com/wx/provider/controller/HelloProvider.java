package com.wx.provider.com.wx.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController   //@ResponseBody ＋ @Controller
public class HelloProvider {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(@RequestParam String  name)
    {
        return "hello"+name+",my names provider";
    }
}
