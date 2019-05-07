package com.ty.eurekaconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    public String hiService(String name) {
        return restTemplate.getForObject("http://eureka-provider/firstCall?name="+name, String.class);
    }
}


