package com.example.SpringFristProject.controller;

import com.example.SpringFristProject.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech")
public class AnimalController {
    private Map<Integer, Animal> animals = new HashMap<>();
    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/app-info")
    public String getAppInfo(){
        return "App Name: " + appName + ", App Version: " + appVersion;
    }

    @GetMapping("/")
    public List<Animal> findAll(){
        return animals.values().stream().toList();
    }
}
