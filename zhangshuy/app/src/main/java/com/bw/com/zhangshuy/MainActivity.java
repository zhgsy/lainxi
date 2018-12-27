package com.bw.com.zhangshuy;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bw.com.zhangshuy.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private TextView text;
    int time=0;
    private Handler handle=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            time--;
            text.setText(time+"秒");
            if (time<=0){
                startActivity(new Intent(MainActivity.this,ZhuActivity.class));
                finish();
                return;
            }
            handle.sendEmptyMessageDelayed(1,1000);
        }
    };

    @Override
    protected void initview() {
        text = findViewById(R.id.textView);
    }

    @Override
    protected void initData() {
        time=5;
        text.setText(time+"秒");
        handle.sendEmptyMessageDelayed(1,1000);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

}
