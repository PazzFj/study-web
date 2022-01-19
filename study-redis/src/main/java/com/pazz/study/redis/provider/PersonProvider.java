package com.pazz.study.redis.provider;

import com.pazz.study.redis.entity.Person;
import com.pazz.study.redis.cache.ICacheProvider;
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
        person.setPid(12);
        person.setPName("WEST");
        person.setPSex("男");
        person.setPAge(47);
//        return JsonUtils.toJson(person);
        return person;
    }

}
