package com.ambow.first.entity;

import java.util.Date;
import java.util.UUID;

/**
 * 用户
 */
public class User {
    private String id; // 主键

    private String name; // 用户名称

    private String sex; // 性别

    private Integer age; // 年龄

    private String phone; // 手机号

    private Date newDate; // 注册日期

    private Date outDate; // 注销日期

    private String place; // 住址

    private Integer borrowNum; // 借阅次数

    private String password; // 登陆密码

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", newDate=" + newDate +
                ", outDate=" + outDate +
                ", place='" + place + '\'' +
                ", borrowNum=" + borrowNum +
                ", password='" + password + '\'' +
                '}';
    }

    public User() {
        this.id = UUID.randomUUID().toString();
    }

    public User(String id, String name, String sex, Integer age, String phone, Date newDate, Date outDate, String
            place, Integer borrowNum, String password) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.newDate = newDate;
        this.outDate = outDate;
        this.place = place;
        this.borrowNum = borrowNum;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getNewDate() {
        return newDate;
    }

    public void setNewDate(Date newDate) {
        this.newDate = newDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public Integer getBorrowNum() {
        return borrowNum;
    }

    public void setBorrowNum(Integer borrowNum) {
        this.borrowNum = borrowNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}