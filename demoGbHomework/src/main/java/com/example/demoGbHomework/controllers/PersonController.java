package com.example.demoGbHomework.controllers;

import com.example.demoGbHomework.model.People;
import com.example.demoGbHomework.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @GetMapping("/user")
    public User restUser(){

        User user=new User("Ivan",42,"guglik@rambler.ru");
        return user;
    }
    @GetMapping("/people")
    public People restPeople(){
        return new People(1,"Ivan");
    }
}
