package com.ty.eurekaconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    //使用@HystrixCommand注解启用熔断器的功能，当服务熔断后，将不调用远程服务，直接调用本地的handleError方法
    @HystrixCommand(fallbackMethod = "handleError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://eureka-provider/firstCall?name=" + name, String.class);
    }

    public String handleError(String name) {
        return name + "在访问远程服务时，被熔断了，调用本地的方法";
    }
}

