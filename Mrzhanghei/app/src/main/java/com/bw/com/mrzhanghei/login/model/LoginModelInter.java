package com.bw.com.mrzhanghei.login.model;

import com.bw.com.mrzhanghei.utils.MyTask;

public class LoginModelInter implements ILoginModelInter{


    @Override
    public void login(final String url, final String username, final String pwd, final ILoginCallBack loginCallBack) {
        new Runnable() {
            @Override
            public void run() {
                new MyTask<String>(url,username,pwd).setTaskListener(new MyTask.TaskListeners() {
                    @Override
                    public void result(String t) {
                        if (t!=null){
                            loginCallBack.onStatus(t);
                        }else{
                            loginCallBack.onFailed();
                        }
                    }
                }).execute();
            }
        }.run();
    }

}
