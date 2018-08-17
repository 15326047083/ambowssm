package com.ambow.first.vo;

import java.util.Date;

public class DonateCountVo {
    private String id;

    private String bookId;

    private String userName;

    private String userPhone;

    private Date donateTime;

    private int count;// 租书次数

    @Override
    public String toString() {
        return "DonateCountVo{" +
                "id='" + id + '\'' +
                ", bookId='" + bookId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", donateTime=" + donateTime +
                ", count=" + count +
                '}';
    }

    public DonateCountVo(){}
    public DonateCountVo(String id, String bookId, String userName, String userPhone, Date donateTime, int count) {
        this.id = id;
        this.bookId = bookId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.donateTime = donateTime;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Date getDonateTime() {
        return donateTime;
    }

    public void setDonateTime(Date donateTime) {
        this.donateTime = donateTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
