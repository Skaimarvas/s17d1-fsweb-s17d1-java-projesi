package com.example.SpringFristProject.controller;

import com.example.SpringFristProject.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<Animal> findAll(){
        return animals.values().stream().toList();
    }
    @GetMapping("/{id}")
    public Animal findAnimal(@PathVariable int id){
        return animals.get(id);
    }

    @PostMapping
    public void addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
    }

    @PutMapping("/{id}")
    public void updateAnimal(@PathVariable int id, @RequestBody Animal updatedAnimal){
        if(animals.containsKey(id)){
            Animal exAnimal = animals.get(id);
            exAnimal.setName(updatedAnimal.getName());
        }
    }
    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable int id) {
        animals.remove(id);
    }
}
