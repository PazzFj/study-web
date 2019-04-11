package com.pazz.springboot.redis.example.controller;

import com.pazz.springboot.redis.example.entity.PersonEntity;
import com.pazz.springboot.redis.example.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2019/4/11 16:24
 * @description:
 */
@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @GetMapping("query")
    public List<PersonEntity> query(@RequestParam("name") String name){
        return personService.findPersonByParam(name);
    }

    @GetMapping("getById")
    public PersonEntity getByName(@RequestParam("id") int id){
        return personService.findPersonById(id);
    }

}
