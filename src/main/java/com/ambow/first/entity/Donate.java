package com.ambow.first.entity;

import java.util.UUID;

/**
 * 捐赠
 */
public class Donate {
    private String id; // ID

    private String bookId; // 图书ID

    private String userName; // 捐赠人姓名

    private String userPhone; // 捐赠人电话

    private String donateTime; // 捐赠时间

    @Override
    public String toString() {
        return "Donate{" +
                "id='" + id + '\'' +
                ", bookId='" + bookId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", donateTime='" + donateTime + '\'' +
                '}';
    }

    public Donate() {
        this.id = UUID.randomUUID().toString();
    }

    public Donate(String id, String bookId, String userName, String userPhone, String donateTime) {

        this.id = id;
        this.bookId = bookId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.donateTime = donateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId == null ? null : bookId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getDonateTime() {
        return donateTime;
    }

    public void setDonateTime(String donateTime) {
        this.donateTime = donateTime == null ? null : donateTime.trim();
    }
}