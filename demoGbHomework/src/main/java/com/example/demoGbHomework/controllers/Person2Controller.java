package com.example.demoGbHomework.controllers;

import com.example.demoGbHomework.model.Person2;
import com.example.demoGbHomework.service.Person2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Person2Controller {
    @Autowired
    Person2Service person2Service;

    @GetMapping("/person2")
    public List<Person2> person2(){
        return person2Service.findAll();
    }

    @PostMapping("/person22")
    public void save(@RequestBody Person2 person2){
        person2Service.save(person2);
    }

    @GetMapping("/person2Print")
    public String printPerson2(Model model){
        model.addAttribute("items",person2Service.findAll());
        return "person2";
    }
}
