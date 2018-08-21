package com.ambow.first.vo;

import java.util.Arrays;

public class PieVo {
    private int[] count;
    private String[] name;
    public PieVo(){}

    public PieVo(int[] count, String[] name) {
        this.count = count;
        this.name = name;
    }

    @Override
    public String toString() {
        return "PieVo{" +
                "count=" + Arrays.toString(count) +
                ", name=" + Arrays.toString(name) +
                '}';
    }

    public int[] getCount() {
        return count;
    }

    public void setCount(int[] count) {
        this.count = count;
    }

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }
}
