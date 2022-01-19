package com.pazz.study.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Table;
import java.util.Date;

/**
 * @author: Peng Jian
 * @date: 2018/6/21 17:17
 * @description:
 */
@Data
@Table(name = "t_login")
public class LoginEntity {

    private String id;

    private String createUser;

    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String modifyUser;

    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    private String userName;

    private String passWord;

    private int rank;

    private String active;

    public LoginEntity() {
    }

    public LoginEntity(String userName) {
        this.userName = userName;
    }

    public LoginEntity(String id, String createUser, Date createTime, String modifyUser, Date modifyTime, String userName, String passWord, int rank, String active) {
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

    @Override
    public String toString() {
        return "LoginEntity{" +
                "id='" + id + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", modifyUser='" + modifyUser + '\'' +
                ", modifyTime=" + modifyTime +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", rank=" + rank +
                ", active='" + active + '\'' +
                '}';
    }
}
