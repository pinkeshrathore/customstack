package com.imanage.model;


public class StackInput {
    private int value;
    private int size;

    public StackInput() {
        value = -1;
        size = -1;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
