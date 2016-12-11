package com.astuetz.viewpager.extensions.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tree4.R;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegActivity extends AppCompatActivity {

    private EditText editText_name, editText_password, editText_email, editText_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        editText_name = (EditText) findViewById(R.id.editText_name);
        editText_password = (EditText) findViewById(R.id.editText_password);
        editText_email = (EditText) findViewById(R.id.editText_email);
        editText_icon = (EditText) findViewById(R.id.editText_icon);

    }

    //注册功能
    public void registerClick(View v) {
        final String name = editText_name.getText().toString();
        final String password = editText_password.getText().toString();
        final String email = editText_email.getText().toString();
        //final String icon = editText_icon.getText().toString();


        //获取图片文件的路径
        //String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+"/2.jpg ";

        //图片上传
        // final BmobFile bmobFile = new BmobFile(new File(path));
        // bmobFile.uploadblock(new UploadFileListener() {
        // @Override
        //public void done(BmobException e) {
        //if(e == null){


        //user.setIcon(bmobFile);
        //注册
        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        user.setEmail(email);;
        user.signUp(new SaveListener<User>() {
            @Override
            public void done(User s, BmobException e){
                if(e == null){
                    Toast.makeText(RegActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(RegActivity.this, "注册失败", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}