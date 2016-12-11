package com.astuetz.viewpager.extensions.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tree4.R;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends AppCompatActivity {

    private EditText editText_username,editText_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //初始化Bmob
        Bmob.initialize(this,"fc45a0ea06f6d1a2ababa77962b9f853");

        editText_username = (EditText) findViewById(R.id.username);
        editText_password = (EditText) findViewById(R.id.password);

    }

    public void loginClick(View v){
        String username = editText_username.getText().toString();
        String password = editText_password.getText().toString();

        final BmobUser bmobUser = new BmobUser();
        bmobUser.setUsername(username);
        bmobUser.setPassword(password);
        bmobUser.login(new SaveListener<BmobUser>() {

            @Override
            public void done(BmobUser bmobUser, BmobException e) {
                if (e == null) {
                    User user = BmobUser.getCurrentUser(User.class);
                    // StringBuffer userMessage = new StringBuffer();
                    // userMessage.append("username = " + user.getUsername());
                    //userMessage.append(",email = "+ user.getEmail());
                    if (bmobUser != null) {
                        if (user.getEmailVerified()) {
                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("user", user);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "用户未激活邮箱", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Intent intent = new Intent(LoginActivity.this,RegActivity.class);
                        startActivity(intent);
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "登陆失败", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    public void regClick(View v){
        Intent intent = new Intent(this,RegActivity.class);
        startActivity(intent);
    }



}
