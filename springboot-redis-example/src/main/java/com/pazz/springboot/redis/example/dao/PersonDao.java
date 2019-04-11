package com.pazz.springboot.redis.example.dao;

import com.pazz.springboot.redis.example.entity.PersonEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2019/4/11 16:13
 * @description:
 */
@Repository
public interface PersonDao {

    List<PersonEntity> findPersonByParam(@Param("name") String name);

    PersonEntity findPersonById(int id);

}
