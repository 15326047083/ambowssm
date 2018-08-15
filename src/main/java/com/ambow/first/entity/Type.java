package com.ambow.first.entity;

import java.util.UUID;

/**
 * 书架
 */
public class Type {
    private String id; // ID

    private String name; // 书架名称

    private String place; // 书架地址

    private Integer bookNum; // 图书数量

    @Override
    public String toString() {
        return "Type{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", bookNum=" + bookNum +
                '}';
    }

    public Type() {
        this.id = UUID.randomUUID().toString();
    }

    public Type(String id, String name, String place, Integer bookNum) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.bookNum = bookNum;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }
}