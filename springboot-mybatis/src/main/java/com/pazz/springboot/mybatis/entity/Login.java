package com.pazz.springboot.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pazz.springboot.mybatis.util.DateJsonSerializer;
import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author: Peng Jian
 * @date: 2018/6/21 17:17
 * @description:
 */
@Table(name = "t_login")
@Data
public class Login {

    @Id
    private String id;
    private String createUser;
    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonSerialize(using = DateJsonSerializer.class)
    private Date createTime;
    private String modifyUser;
    private Date modifyTime;
    private String userName;
    private String passWord;
    private int rank;
    private String active;

    public Login() {
    }

    public Login(String id, String createUser, Date createTime, String modifyUser, Date modifyTime, String userName, String passWord, int rank, String active) {
        this.id = id;
        this.createUser = createUser;
        this.createTime = createTime;
        this.modifyUser = modifyUser;
        this.modifyTime = modifyTime;
        this.userName = userName;
        this.passWord = passWord;
        this.rank = rank;
        this.active = active;
    }
}
