package com.bw.com.mrzhanghei.login.model;

public interface ILoginModelInter {
    public void login(String url,String username,String pwd,ILoginCallBack loginCallBack);
    interface ILoginCallBack{
        public void onStatus(String data);
        public void onFailed();
    }
}
