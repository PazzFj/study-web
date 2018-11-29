package com.pazz.springboot.redis.cache;

import com.pazz.springboot.redis.entity.Person;
import com.pazz.springboot.redis.provider.ICacheProvider;
import com.pazz.springboot.redis.util.JsonUtils;
import org.springframework.stereotype.Component;

/**
 * @author: 彭坚
 * @create: 2018/11/28 11:16
 * @description:
 */
@Component
public class PersonProvider implements ICacheProvider<String> {

    public String get(String key) {
        System.out.println("key: " + key);
        Person person = new Person();
        person.setPid(12);
        person.setPName("WEST");
        person.setPSex("男");
        person.setPAge(47);
        return JsonUtils.toJson(person);
    }

}
