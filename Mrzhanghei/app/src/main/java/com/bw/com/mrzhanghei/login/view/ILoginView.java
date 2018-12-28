package com.bw.com.mrzhanghei.login.view;

public interface ILoginView {
    //Toast形式提示
    public void showMsg(String msg);
    //加载提示框
    public void   showLoading();
    //隐藏加载提示框
    public void hiddenLoading();
    //页面跳转
    public void jumpActivity();
}
