package com.ambow.first.entity;

import java.util.UUID;

/**
 * 失信
 */
public class Lost {
    private String id; // 主键

    private String userId; // 用户ID

    private String borrowId; // 借阅ID

    @Override
    public String toString() {
        return "Lost{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", borrowId='" + borrowId + '\'' +
                '}';
    }

    public Lost() {
        this.id = UUID.randomUUID().toString();
    }

    public Lost(String id, String userId, String borrowId) {
        this.id = id;
        this.userId = userId;
        this.borrowId = borrowId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId == null ? null : borrowId.trim();
    }
}