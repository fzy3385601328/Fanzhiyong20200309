package com.example.fanzhiyong20200309.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<V extends BasePresenter>extends AppCompatActivity implements IBaseView {

    BasePresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = initPresenter();

        //布局
        setContentView(getLayoutResID());

        //控件
        initView();

        //数据
        getData();
    }

    protected abstract BasePresenter initPresenter();

    protected abstract int getLayoutResID();

    protected abstract void initView();

    protected abstract void getData();
}
