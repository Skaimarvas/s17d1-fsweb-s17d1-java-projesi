package com.example.SpringFristProject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workintech")
public class AnimalController {

    @Value("${app.name}")
    private String appName;

    @Value("{app.version}")
    private String appVersion;

    @GetMapping("/app-info")
    public String getAppInfo(){
        return "App Name: " + appName + ", App Version: " + appVersion;
    }
}
