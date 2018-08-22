package com.ambow.first.vo;

import java.util.Date;

/**
 * 图书、书架vo
 */
public class BookDonateVo {

    private String bookId; // 图书ID
    private String bookName; // 图书名称
    private String userName;//捐赠人
    private String userPhone;//联系方式
    private Date donateTime;//捐赠时间

    public BookDonateVo(String bookId, String bookName, String userName, String userPhone, Date donateTime) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.userName = userName;
        this.userPhone = userPhone;
        this.donateTime = donateTime;
    }

    public BookDonateVo() {
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
}
