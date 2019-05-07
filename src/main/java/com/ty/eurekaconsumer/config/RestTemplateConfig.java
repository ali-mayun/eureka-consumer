package com.ty.eurekaconsumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    //表明此RestTemplate开启了负载均衡功能
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
