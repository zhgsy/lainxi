package com.bw.com.mrzhanghei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bw.com.mrzhanghei.login.model.LoginModelInter;
import com.bw.com.mrzhanghei.login.presenter.LoginPresenterInter;
import com.bw.com.mrzhanghei.login.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {


    EditText mLogin,mRegister;
    Button mLoginBut,mRegisterBut;

    String mLoginName,mRegisterPswd;
    private LoginPresenterInter loginPresenterInter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hiddenLoading() {

    }

    @Override
    public void jumpActivity() {
        Log.i("", "jumpActivity: ");
    }
    public void initview(){
        mLogin = findViewById(R.id.login_name_et);
        mRegister = findViewById(R.id.login_pswd_et);
        mLoginBut= findViewById(R.id.login_lgbt);
        mRegisterBut= findViewById(R.id.login_rebt);
        mLoginName = mLogin.getText().toString();
        mRegisterPswd = mRegister.getText().toString();
        //初始化
        loginPresenterInter = new LoginPresenterInter(this);

        mLoginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mLoginName.isEmpty()&&!mRegisterPswd.isEmpty()){
                    loginPresenterInter.loginPre(mLoginName,mRegisterPswd);
                }
            }
        });

    }
}
