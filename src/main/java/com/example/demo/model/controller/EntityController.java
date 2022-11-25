package com.example.demo.model.controller;

import com.example.demo.model.repository.EntityRepository;
import com.example.demo.model.user.Entity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EntityController {

    EntityRepository entityRepository;

    @GetMapping("/test")
    public String test() {
        Entity testEntity0 = new Entity("Mike");
        entityRepository.save(testEntity0);
        System.out.println(testEntity0);
        Entity testEntity1 = new Entity("John");
        entityRepository.save(testEntity1);
        System.out.println(testEntity1);

        return testEntity0 + " " + testEntity1;
    }

    @GetMapping("/all")
    public Iterable<Entity> getAll(){
        Iterable<Entity> entities = new ArrayList<>();
        entities = entityRepository.findAll();
        return entities;
    }


}
