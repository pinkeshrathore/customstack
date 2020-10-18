package com.imanage.model;

import javax.persistence.Entity;
import java.util.Arrays;


public class Stack {
    private int arr[];
    private int top;
    private int totalSize;


    public Stack(int totalSize) {
        this.arr = new int[totalSize];
        this.top = -1;
        this.totalSize = totalSize;
    }

    public int getValue() {
        return arr[top];
    }

    public void addValue(int value) {
        arr[top] = value;
    }

    public int getTop() {
        return top;
    }

    public void incrementTop() {
        this.top++;
    }

    public void decrementTop() {
        this.top--;
    }

    public int getTotalSize() {
        return totalSize;
    }

}
