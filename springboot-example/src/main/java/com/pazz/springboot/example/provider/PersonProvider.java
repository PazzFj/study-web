package com.pazz.springboot.example.provider;

import com.pazz.springboot.example.cache.provider.ITTLCacheProvider;
import com.pazz.springboot.example.entity.Person;
import org.springframework.stereotype.Component;

/**
 * @author: 彭坚
 * @create: 2018/11/30 10:49
 * @description:
 */
@Component
public class PersonProvider implements ITTLCacheProvider<Person> {

    public Person get(String key) {
        System.out.println("key: " + key);
        Person person = new Person();
        person.setPid(88);
        person.setPSex("男");
        person.setPName("WEST");
        person.setPAge(33);
        return person;
    }

}
