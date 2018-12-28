package com.bw.com.mrzhanghei.login.presenter;

import android.util.Log;

import com.bw.com.mrzhanghei.MainActivity;
import com.bw.com.mrzhanghei.login.model.ILoginModelInter;
import com.bw.com.mrzhanghei.login.model.LoginModelInter;
import com.bw.com.mrzhanghei.utils.Api;

public class LoginPresenterInter implements ILoginPresenterInter{

    MainActivity mview;
    private final LoginModelInter loginModelInter;

    //构造器
    public LoginPresenterInter(MainActivity mview) {
        this.mview = mview;
        //初始化model
        loginModelInter = new LoginModelInter();
    }

    @Override
    public void loginPre(String name, String pwd) {
        loginModelInter.login(Api.LOGIN, name, pwd, new ILoginModelInter.ILoginCallBack() {
            @Override
            public void onStatus(String data) {
                //如果成功将跳转
               mview.jumpActivity();
                Log.i("aaa", "onStatus: "+data);
            }

            @Override
            public void onFailed() {

            }
        });
    }
}
