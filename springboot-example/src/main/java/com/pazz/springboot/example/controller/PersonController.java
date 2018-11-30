package com.pazz.springboot.example.controller;

import com.pazz.springboot.example.entity.Person;
import com.pazz.springboot.example.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 彭坚
 * @create: 2018/11/28 0:49
 * @description:
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @ResponseBody
    @GetMapping("/get")
    public Person getPerson(String name){
        return personService.getPerson(name);
    }

    @GetMapping("/add")
    public void addPerson(Person person){
        personService.addPerson(person);
    }

}
