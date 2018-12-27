package com.bw.com.zhangshuy.utils;

import android.content.Context;
import android.os.AsyncTask;

public class MyTask<T> extends AsyncTask<T,T,String> {
    Context context;
    String mpath;
    String mram;
    public MyTask(Context context, String mpath, String mram) {
        this.context = context;
        this.mpath = mpath;
        this.mram = mram;
    }
    private TaskListens taskListens;
    public MyTask setTasklistens(TaskListens taskListens) {
        this.taskListens = taskListens;
        return this;
    }

    @Override
    protected String doInBackground(T... ts) {
        return HttpWorkUtils.getHttpCont(context,mpath,mram);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s!=null){
            taskListens.result(s);
        }
    }
    //定义接口
    public interface TaskListens{
        void result(String t);
    }
}
