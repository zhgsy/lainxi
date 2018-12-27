package com.bw.com.zhangshuy.frag.fra;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.bw.com.zhangshuy.R;
import com.bw.com.zhangshuy.adapter.FragAdapter;
import com.bw.com.zhangshuy.bean.FragBean;
import com.bw.com.zhangshuy.utils.MyTask;
import com.google.gson.Gson;

import java.util.List;

public class Frag_03 extends Fragment {


    private ListView listview;

    String mpath=" http://172.17.8.100/movieApi/movie/v1/findReleaseMovieList?page=1&count=10";
    String mram;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.fragment_frag_03, container, false);
            initview(view);
            new MyTask<String >(getActivity(),mpath,"GET").setTasklistens(new MyTask.TaskListens() {
                @Override
                public void result(String t) {
                    Gson gson=new Gson();
                    FragBean bean = gson.fromJson(t, FragBean.class);
                    List<FragBean.ResultBean> list = bean.getResult();
                   /* Toast.makeText(getActivity(),list.toString(),Toast.LENGTH_SHORT).show();*/
                    FragAdapter adapter=new FragAdapter(getActivity(),list);
                    listview.setAdapter(adapter);
                }
            }).execute();
            return view;
    }
    public  void initview(View view){
        listview = view.findViewById(R.id.glist);
    }

}
