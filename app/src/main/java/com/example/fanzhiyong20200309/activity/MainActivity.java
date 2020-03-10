package com.example.fanzhiyong20200309.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.example.fanzhiyong20200309.R;
import com.example.fanzhiyong20200309.base.BaseActivity;
import com.example.fanzhiyong20200309.base.BasePresenter;
import com.example.fanzhiyong20200309.custom.CustomView;
import com.example.fanzhiyong20200309.presenter.IHomeLoginPresenter;

public class MainActivity extends BaseActivity {
   private ImageView userImg;
   private TextView userName;
    private CustomView customView;


    @Override
    protected BasePresenter initPresenter() {
        return new IHomeLoginPresenter(this);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
         userImg = findViewById(R.id.user_img);
         userName = findViewById(R.id.user_name);
        customView = findViewById(R.id.custom_view);
    }

    @Override
    protected void getData() {
          //接受从登录页面传来的数据
        Intent intent = getIntent();
        String phones = intent.getStringExtra("phone");
        String pwd = intent.getStringExtra("pwd");

        //将传来的数据赋值给布局控件
        Glide.with(MainActivity.this).load(phones).error(R.mipmap.ic_launcher)
                .priority(Priority.IMMEDIATE).into(userImg);
        userName.setText(pwd);


        //设置折线图的方法
        onDrawLine();
    }

    private void onDrawLine() {
        int[] data = {2000,4000,4500,5000,2000,2500,3000,4300,4700,5000,1500};


        customView.setArray(data);
    }
}
