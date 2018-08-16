package com.ambow.first.entity;

import java.util.Date;
import java.util.UUID;

/**
 * 图书
 */
public class Book {
    private String id; // 主键

    private String typeId; // 书架ID

    private String bookName; // 图书名

    private String authorName; // 作者名

    private String press; // 出版社

    private String publishDate; // 出版日期

    private String info; // 简介

    private Integer status; // 图书状态

    private Integer num; // 外借次数

    private String remark; // 备注

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", typeId='" + typeId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", press='" + press + '\'' +
                ", publishDate=" + publishDate +
                ", info='" + info + '\'' +
                ", status=" + status +
                ", num=" + num +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Book() {
        this.id = UUID.randomUUID().toString();
    }

    public Book(String id, String typeId, String bookName, String authorName, String press, String publishDate, String
            info, Integer status, Integer num, String remark) {
        this.id = id;
        this.typeId = typeId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.press = press;
        this.publishDate = publishDate;
        this.info = info;
        this.status = status;
        this.num = num;
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}