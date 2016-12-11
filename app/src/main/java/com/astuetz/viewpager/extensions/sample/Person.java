package com.astuetz.viewpager.extensions.sample;

import cn.bmob.v3.BmobObject;

/**
 * Created by 王茂潼 on 2016/12/10.
 */

public class Person extends BmobObject {
    private String name;
    private String address;
    private int password;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}

