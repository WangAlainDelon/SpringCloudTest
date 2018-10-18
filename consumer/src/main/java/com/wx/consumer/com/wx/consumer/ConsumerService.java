package com.wx.consumer.com.wx.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {
    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "helloError")
    public String getStr(String name)
    {
        //getForObject()的参数是请求服务的注册地址，不能用ip,不然无法实现负载均衡
        //第二个参数是所传参数的类型
        return restTemplate.getForObject("http://PROVIDER/hello?name="+name,String.class);
    }
    private String helloError(String name)
    {
        return "hello"+name+",出现错误，熔断器熔断节点";
    }
}
