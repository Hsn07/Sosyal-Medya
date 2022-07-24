package com.hbacakk.sosyalmedya.data.models;

public class Item<T> {
    int rowType;
    T data;

    public Item(int rowType, T data) {
        this.rowType = rowType;
        this.data = data;
    }

    public int getRowType() {
        return rowType;
    }

    public void setRowType(int rowType) {
        this.rowType = rowType;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
