package com.example.dsm_t1_mr171621_gl202882.model;

import android.content.ContentValues;

import com.example.dsm_t1_mr171621_gl202882.model.db.DBHelper;

public class User {
    int id;
    String name, email, password;

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
}
