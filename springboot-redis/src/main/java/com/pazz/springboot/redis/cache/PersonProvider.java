package com.pazz.springboot.redis.cache;

import com.pazz.springboot.redis.entity.Person;
import com.pazz.springboot.redis.provider.ICacheProvider;
import org.springframework.stereotype.Component;

/**
 * @author: 彭坚
 * @create: 2018/11/28 11:16
 * @description:
 */
@Component
public class PersonProvider implements ICacheProvider<Person> {

    public Person get(String key) {
        System.out.println("key: " + key);
        Person person = new Person();
        person.setPid(11);
        person.setPName("Provider");
        person.setPsex("男");
        person.setPAge(66);
        return person;
    }

}
