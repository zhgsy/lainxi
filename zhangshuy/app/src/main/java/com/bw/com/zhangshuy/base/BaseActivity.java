package com.bw.com.zhangshuy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());//初始化布局
        //初始化控件
        initview();
        //初始化数据
        initData();
    }


    protected abstract void initview();

    protected abstract void initData();
    protected abstract int initLayout();

}
