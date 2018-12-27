package com.bw.com.zhangshuy;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.bw.com.zhangshuy.base.BaseActivity;
import com.bw.com.zhangshuy.frag.BlankFragment;
import com.bw.com.zhangshuy.frag.BlankFragment2;
import com.bw.com.zhangshuy.frag.BlankFragment3;
import com.bw.com.zhangshuy.frag.BlankFragment4;
import com.bw.com.zhangshuy.frag.BlankFragment5;

public class ZhuActivity extends BaseActivity {

    private FrameLayout frag_layout;
    private RadioGroup radiogroup;
    //初始化控件
    @Override
    protected void initview() {
        frag_layout = findViewById(R.id.frag_layout);
        radiogroup = findViewById(R.id.zradio);
    }

    @Override
    protected void initData() {
        final FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        final BlankFragment frag01=new BlankFragment();
        final BlankFragment2 frag02=new BlankFragment2();
        final BlankFragment3 frag03=new BlankFragment3();
        final BlankFragment4 frag04=new BlankFragment4();
        final BlankFragment5 frag05=new BlankFragment5();
        transaction.add(R.id.frag_layout,frag01);
        transaction.add(R.id.frag_layout,frag02);
        transaction.add(R.id.frag_layout,frag03);
        transaction.add(R.id.frag_layout,frag04);
        transaction.add(R.id.frag_layout,frag05);
        transaction.show(frag01).hide(frag02).hide(frag03).hide(frag04).hide(frag05);
        transaction.commit();
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction beginTransaction = manager.beginTransaction();
                switch (checkedId){
                    case R.id.butn1:
                        beginTransaction.show(frag01).hide(frag02).hide(frag03).hide(frag04).hide(frag05);
                        break;
                    case R.id.butn2:
                        beginTransaction.show(frag02).hide(frag01).hide(frag03).hide(frag04).hide(frag05);
                        break;
                    case R.id.butn3:
                        beginTransaction.show(frag03).hide(frag01).hide(frag02).hide(frag04).hide(frag05);
                        break;
                    case R.id.butn4:
                        beginTransaction.show(frag04).hide(frag01).hide(frag02).hide(frag03).hide(frag05);
                        break;
                    case R.id.butn5:
                        beginTransaction.show(frag05).hide(frag01).hide(frag02).hide(frag03).hide(frag04);
                        break;
                }
                beginTransaction.commit();
            }
        });
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_zhu;
    }

}
