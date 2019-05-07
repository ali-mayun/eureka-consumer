package com.ty.eurekaconsumer.controller;

import com.ty.eurekaconsumer.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {

    @Autowired
    RibbonService ribbonService;

    @GetMapping("/ribbonService")
    public String hi(@RequestParam String name) {

        return ribbonService.hiService( name );
    }
}
