package com.example.tema2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    private int uid;
    @ColumnInfo(name="name")
    private String name;
    @ColumnInfo(name="mark")
    private String mark;

    public String getName() {
        return name;
    }

    public String getMark() {
        return mark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
