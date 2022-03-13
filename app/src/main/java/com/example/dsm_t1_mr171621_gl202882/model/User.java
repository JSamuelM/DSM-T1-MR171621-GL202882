package com.example.dsm_t1_mr171621_gl202882.model;

import android.content.ContentValues;

import com.example.dsm_t1_mr171621_gl202882.model.db.DBHelper;

public class User {
    int id;
    String name, email, password;

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_USER_ID, id);
        values.put(DBHelper.COLUMN_USER_NAME, name);
        values.put(DBHelper.COLUMN_USER_EMAIL, email);
        values.put(DBHelper.COLUMN_USER_PASSWORD, password);
        return values;
    }
}
