package com.ambow.first.vo;

import java.util.Arrays;
import java.util.Date;

public class CountDateVo {
    private int[] count;
    private String[] date;

    public CountDateVo() {
    }

    @Override
    public String toString() {
        return "CountDateVo{" +
                "count=" + Arrays.toString(count) +
                ", date=" + Arrays.toString(date) +
                '}';
    }

    public int[] getCount() {
        return count;
    }

    public void setCount(int[] count) {
        this.count = count;
    }

    public String[] getDate() {
        return date;
    }

    public void setDate(String[] date) {
        this.date = date;
    }

    public CountDateVo(int[] count, String[] date) {
        this.count = count;
        this.date = date;
    }
}
