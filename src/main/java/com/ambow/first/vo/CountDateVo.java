package com.ambow.first.vo;

import java.util.Arrays;
import java.util.Date;

public class CountDateVo {
    private int[] count1;
    private int[] count2;
    private String[] date;


    public CountDateVo() {
    }

    public CountDateVo(int[] count1, int[] count2, String[] date) {
        this.count1 = count1;
        this.count2 = count2;
        this.date = date;
    }

    @Override
    public String toString() {
        return "CountDateVo{" +
                "count1=" + Arrays.toString(count1) +
                ", count2=" + Arrays.toString(count2) +
                ", date=" + Arrays.toString(date) +
                '}';
    }

    public int[] getCount1() {
        return count1;
    }

    public void setCount1(int[] count1) {
        this.count1 = count1;
    }

    public int[] getCount2() {
        return count2;
    }

    public void setCount2(int[] count2) {
        this.count2 = count2;
    }

    public String[] getDate() {
        return date;
    }

    public void setDate(String[] date) {
        this.date = date;
    }
}
