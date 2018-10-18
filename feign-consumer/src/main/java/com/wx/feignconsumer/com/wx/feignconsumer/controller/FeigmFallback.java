package com.wx.feignconsumer.com.wx.feignconsumer.controller;

import org.springframework.stereotype.Component;

@Component
public class FeigmFallback implements FeignInterface {
    @Override
    public String sayHello(String name) {
        return "通过feign的调用失败";
    }
}
