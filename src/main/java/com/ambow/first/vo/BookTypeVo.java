package com.ambow.first.vo;

import java.util.Date;

/**
 * 图书、书架vo
 */
public class BookTypeVo {
    private String typeId; // 书架ID
    private String typeName; // 书架名
    private String typePlace; // 书架位置
    private Integer bookNum; // 图书数量
    private String bookId; // 图书ID
    private String bookName; // 图书名称
    private String bookAuthorName; // 图书作者
    private String bookPress; // 图书出版社
    private Date bookPublishDate; // 图书出版日期
    private String bookInfo; // 图书简介
    private Integer bookStatus; // 图书状态
    private Integer bookBorrowNum; // 被借次数
    private String bookRemark; // 图书备注

    @Override
    public String toString() {
        return "BookTypeVo{" +
                "typeId='" + typeId + '\'' +
                ", typeName='" + typeName + '\'' +
                ", typePlace='" + typePlace + '\'' +
                ", bookNum=" + bookNum +
                ", bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthorName='" + bookAuthorName + '\'' +
                ", bookPress='" + bookPress + '\'' +
                ", bookPublishDate=" + bookPublishDate +
                ", bookInfo='" + bookInfo + '\'' +
                ", bookStatus=" + bookStatus +
                ", bookBorrowNum=" + bookBorrowNum +
                ", bookRemark='" + bookRemark + '\'' +
                '}';
    }

    public BookTypeVo() {
    }

    public BookTypeVo(String typeId, String typeName, String typePlace, Integer bookNum, String bookId, String
            bookName, String bookAuthorName, String bookPress, Date bookPublishDate, String bookInfo, Integer
                              bookStatus, Integer bookBorrowNum, String bookRemark) {

        this.typeId = typeId;
        this.typeName = typeName;
        this.typePlace = typePlace;
        this.bookNum = bookNum;
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthorName = bookAuthorName;
        this.bookPress = bookPress;
        this.bookPublishDate = bookPublishDate;
        this.bookInfo = bookInfo;
        this.bookStatus = bookStatus;
        this.bookBorrowNum = bookBorrowNum;
        this.bookRemark = bookRemark;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypePlace() {
        return typePlace;
    }

    public void setTypePlace(String typePlace) {
        this.typePlace = typePlace;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
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

    public Integer getBookBorrowNum() {
        return bookBorrowNum;
    }

    public void setBookBorrowNum(Integer bookBorrowNum) {
        this.bookBorrowNum = bookBorrowNum;
    }

    public String getBookRemark() {
        return bookRemark;
    }

    public void setBookRemark(String bookRemark) {
        this.bookRemark = bookRemark;
    }
}
