package com.ambow.first.vo;

import java.util.Date;

public class LostUserVo {


    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public String getLostId() {
        return lostId;
    }

    public void setLostId(String lostId) {
        this.lostId = lostId;
    }

    public String getlBookId() {
        return lBookId;
    }

    public void setlBookId(String lBookId) {
        this.lBookId = lBookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getUserPlace() {
        return userPlace;
    }

    public void setUserPlace(String userPlace) {
        this.userPlace = userPlace;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getwId() {
        return wId;
    }

    public void setwId(String wId) {
        this.wId = wId;
    }

    public String getwBookId() {
        return wBookId;
    }

    public void setwBookId(String wBookId) {
        this.wBookId = wBookId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "LostUserVo{" +
                "lid='" + lid + '\'' +
                ", lostId='" + lostId + '\'' +
                ", lBookId='" + lBookId + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userPlace='" + userPlace + '\'' +
                ", bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", wId='" + wId + '\'' +
                ", wBookId='" + wBookId + '\'' +
                ", start='" + start + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }

    public LostUserVo(String lid, String lostId, String lBookId, String userId, String userName, String userPhone, String userPlace, String bookId, String bookName, String wId, String wBookId, String start, String endDate) {
        this.lid = lid;
        this.lostId = lostId;
        this.lBookId = lBookId;
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userPlace = userPlace;
        this.bookId = bookId;
        this.bookName = bookName;
        this.wId = wId;
        this.wBookId = wBookId;
        this.start = start;
        this.endDate = endDate;
    }

    private String lid; // 失信表主键
    private String lostId;//失信表的用户ID
    private String lBookId;
    private String userId; // 用户ID
    private String userName; // 用户名称
    private String userPhone; // 手机号

    private String userPlace; // 住址
    private String bookId;
    private String bookName;

    private String wId;
    private String wBookId;
    private String start;
    private String endDate;

    public LostUserVo(){

    }


}
