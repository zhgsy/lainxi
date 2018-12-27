package com.bw.com.zhangshuy.frag.fra;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.bw.com.zhangshuy.R;
import com.bw.com.zhangshuy.adapter.Myadapter;
import com.bw.com.zhangshuy.bean.Bean;
import com.bw.com.zhangshuy.utils.MyTask;
import com.bw.com.zhangshuy.xlistview.XListView;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Frag_01 extends Fragment implements XListView.IXListViewListener {

    private Myadapter myadapter;
    private ListView listview;
    int page=1;
    String mpath="http://172.17.8.100/movieApi/movie/v1/findHotMovieList?page=1&count=10"+page+"";
    private XListView xlist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.fragment_frag_2, container, false);
             initview(view);
            new MyTask<String>(getActivity(),mpath,"GET").setTasklistens(new MyTask.TaskListens() {
                @Override
                public void result(String t) {
                    Gson gson=new Gson();
                    Bean bean = gson.fromJson(t, Bean.class);
                    List<Bean.ResultBean> list = bean.getResult();
               /*     Toast.makeText(getActivity(),list.toString(),Toast.LENGTH_SHORT).show();*/
                    myadapter = new Myadapter(getActivity(),list);
                    xlist.setAdapter(myadapter);

                }
            }).execute();
        return view;
    }

    public void initview(View view){
        xlist = view.findViewById(R.id.xlistview);
        xlist.setPullRefreshEnable(true);
        xlist.setPullLoadEnable(true);
        xlist.setXListViewListener(this);
    }

    @Override
    public void onRefresh() {
        page--;
        new Runnable() {
            @Override
            public void run() {
                onload();
            }
        }.run();

    }

    @Override
    public void onLoadMore() {
        page++;
        new Runnable() {
            @Override
            public void run() {
                onload();
                new MyTask<String>(getActivity(),mpath,"GET").setTasklistens(new MyTask.TaskListens() {

                    private Myadapter myadapter;

                    @Override
                    public void result(String t) {
                        Gson gson=new Gson();
                        Bean bean = gson.fromJson(t, Bean.class);
                        List<Bean.ResultBean> list = bean.getResult();
                        /*     Toast.makeText(getActivity(),list.toString(),Toast.LENGTH_SHORT).show();*/
                        myadapter = new Myadapter(getActivity(),list);
                        xlist.setAdapter(myadapter);

                    }
                }).execute();
                myadapter.notifyDataSetChanged();
            }
        }.run();
    }
    public void onload(){
        xlist.stopLoadMore();
        xlist.stopRefresh();
        xlist.setRefreshTime(gettime());
    }
    public String gettime(){
        SimpleDateFormat format = new SimpleDateFormat("yyy年MM月dd日 HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return format.format(date);
    }
}
