package com.wx.feignconsumer.com.wx.feignconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    //可以改编译器，让他不显示错误
    @Autowired
    private FeignInterface feignInterface;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @RequestMapping(value = {"/hi","/hello"},method = RequestMethod.GET)
    public  String sayHi(@RequestParam(value = "name") String name)
    {
        ServiceInstance serviceInstance = loadBalancerClient.choose("PROVIDER");
        return feignInterface.sayHello(name)+"port="+serviceInstance.getPort();
    }
}
