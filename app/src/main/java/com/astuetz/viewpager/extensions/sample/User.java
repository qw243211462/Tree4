package com.astuetz.viewpager.extensions.sample;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by 王茂潼 on 2016/12/10.
 */

public class User extends BmobUser {

    private BmobFile icon;

    public User() {

    }

    public User(BmobFile icon) {
        this.icon = icon;
    }

    public BmobFile getIcon() {
        return icon;
    }

    public void setIcon(BmobFile icon) {
        this.icon = icon;
    }
}