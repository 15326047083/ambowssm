package com.ambow.first.vo;

import java.util.Date;

public class BorrowBookUserVo {



    public BorrowBookUserVo(){

    }


    public BorrowBookUserVo(String borrowId, String borrowDate, String borrowSrdate, Long borrowSrtimeStamp, Integer borrowStatus, String bookId, String bookName, String bookAuthorName, String bookPress, Date bookPublishDate, String bookInfo, Integer bookStatus, Integer bookNum, String bookRemark, String userId, String userName, String userSex, Integer userAge, String userPhone, Date userNewDate, Date userOutDate, String userPlace, Integer borrowNum, String userPassword) {
        this.borrowId = borrowId;
        this.borrowDate = borrowDate;
        this.borrowSrdate = borrowSrdate;
        this.borrowSrtimeStamp = borrowSrtimeStamp;
        this.borrowStatus = borrowStatus;
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthorName = bookAuthorName;
        this.bookPress = bookPress;
        this.bookPublishDate = bookPublishDate;
        this.bookInfo = bookInfo;
        this.bookStatus = bookStatus;
        this.bookNum = bookNum;
        this.bookRemark = bookRemark;
        this.userId = userId;
        UserName = userName;
        UserSex = userSex;
        UserAge = userAge;
        UserPhone = userPhone;
        UserNewDate = userNewDate;
        UserOutDate = userOutDate;
        UserPlace = userPlace;
        this.borrowNum = borrowNum;
        UserPassword = userPassword;
    }

    @Override
    public String toString() {
        return "BorrowBookUserVo{" +
                "borrowId='" + borrowId + '\'' +
                ", borrowDate='" + borrowDate + '\'' +
                ", borrowSrdate='" + borrowSrdate + '\'' +
                ", borrowSrtimeStamp=" + borrowSrtimeStamp +
                ", borrowStatus=" + borrowStatus +
                ", bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthorName='" + bookAuthorName + '\'' +
                ", bookPress='" + bookPress + '\'' +
                ", bookPublishDate=" + bookPublishDate +
                ", bookInfo='" + bookInfo + '\'' +
                ", bookStatus=" + bookStatus +
                ", bookNum=" + bookNum +
                ", bookRemark='" + bookRemark + '\'' +
                ", userId='" + userId + '\'' +
                ", UserName='" + UserName + '\'' +
                ", UserSex='" + UserSex + '\'' +
                ", UserAge=" + UserAge +
                ", UserPhone='" + UserPhone + '\'' +
                ", UserNewDate=" + UserNewDate +
                ", UserOutDate=" + UserOutDate +
                ", UserPlace='" + UserPlace + '\'' +
                ", borrowNum=" + borrowNum +
                ", UserPassword='" + UserPassword + '\'' +
                '}';
    }

    private String borrowId;//借阅表ID
    private String borrowDate;//外借时间
    private String borrowSrdate; // 应归还时间
    private Long borrowSrtimeStamp; // 应归还时间戳
    private Integer borrowStatus; // 借阅状态查看 0为未借出 1为已借出
    private String bookId; // 图书ID
    private String bookName; // 图书名

    private String bookAuthorName; // 作者名

    private String bookPress; // 出版社

    private Date bookPublishDate; // 出版日期

    private String bookInfo; // 简介

    private Integer bookStatus; // 图书状态

    private Integer bookNum; // 外借次数

    private String bookRemark; // 备注

    private String userId; // 用户ID

    private String UserName; // 用户名称

    private String UserSex; // 性别

    private Integer UserAge; // 年龄

    private String UserPhone; // 手机号

    private Date UserNewDate; // 注册日期

    private Date UserOutDate; // 注销日期

    private String UserPlace; // 住址



    private Integer borrowNum; // 借阅次数
    private String UserPassword; // 登陆密码

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getBorrowSrdate() {
        return borrowSrdate;
    }

    public void setBorrowSrdate(String borrowSrdate) {
        this.borrowSrdate = borrowSrdate;
    }

    public Long getBorrowSrtimeStamp() {
        return borrowSrtimeStamp;
    }

    public void setBorrowSrtimeStamp(Long borrowSrtimeStamp) {
        this.borrowSrtimeStamp = borrowSrtimeStamp;
    }

    public Integer getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(Integer borrowStatus) {
        this.borrowStatus = borrowStatus;
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

    public String getBookAuthorName() {
        return bookAuthorName;
    }

    public void setBookAuthorName(String bookAuthorName) {
        this.bookAuthorName = bookAuthorName;
    }

    public String getBookPress() {
        return bookPress;
    }

    public void setBookPress(String bookPress) {
        this.bookPress = bookPress;
    }

    public Date getBookPublishDate() {
        return bookPublishDate;
    }

    public void setBookPublishDate(Date bookPublishDate) {
        this.bookPublishDate = bookPublishDate;
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo;
    }

    public Integer getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    public String getBookRemark() {
        return bookRemark;
    }

    public void setBookRemark(String bookRemark) {
        this.bookRemark = bookRemark;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserSex() {
        return UserSex;
    }

    public void setUserSex(String userSex) {
        UserSex = userSex;
    }

    public Integer getUserAge() {
        return UserAge;
    }

    public void setUserAge(Integer userAge) {
        UserAge = userAge;
    }

    public String getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }

    public Date getUserNewDate() {
        return UserNewDate;
    }

    public void setUserNewDate(Date userNewDate) {
        UserNewDate = userNewDate;
    }

    public Date getUserOutDate() {
        return UserOutDate;
    }

    public void setUserOutDate(Date userOutDate) {
        UserOutDate = userOutDate;
    }

    public String getUserPlace() {
        return UserPlace;
    }

    public void setUserPlace(String userPlace) {
        UserPlace = userPlace;
    }

    public Integer getBorrowNum() {
        return borrowNum;
    }

    public void setBorrowNum(Integer borrowNum) {
        this.borrowNum = borrowNum;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }
}
