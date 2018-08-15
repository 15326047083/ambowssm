package com.ambow.first.entity;

import java.util.Date;
import java.util.UUID;

/**
 * 借阅
 */
public class Borrow {
    private String id; // 主键

    private String bookId; // 图书ID

    private String userId; // 用户ID

    private Date borrowDate; // 外借时间

    private Date sRDate; // 应归还时间

    private Long sRTimeStamp; // 应归还时间戳

    private Integer status; // 借阅状态看

    @Override
    public String toString() {
        return "Borrow{" +
                "id='" + id + '\'' +
                ", bookId='" + bookId + '\'' +
                ", userId='" + userId + '\'' +
                ", borrowDate=" + borrowDate +
                ", sRDate=" + sRDate +
                ", sRTimeStamp=" + sRTimeStamp +
                ", status=" + status +
                '}';
    }

    public Borrow() {
        this.id = UUID.randomUUID().toString();
    }

    public Borrow(String id, String bookId, String userId, Date borrowDate, Date sRDate, Long sRTimeStamp, Integer
            status) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.borrowDate = borrowDate;
        this.sRDate = sRDate;
        this.sRTimeStamp = sRTimeStamp;
        this.status = status;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getsRDate() {
        return sRDate;
    }

    public void setsRDate(Date sRDate) {
        this.sRDate = sRDate;
    }

    public Long getsRTimeStamp() {
        return sRTimeStamp;
    }

    public void setsRTimeStamp(Long sRTimeStamp) {
        this.sRTimeStamp = sRTimeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}