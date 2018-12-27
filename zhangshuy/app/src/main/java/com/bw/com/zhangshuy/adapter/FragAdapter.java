package com.bw.com.zhangshuy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bw.com.zhangshuy.R;
import com.bw.com.zhangshuy.bean.FragBean;

import java.util.List;

public class FragAdapter extends BaseAdapter {
    Context context;
    List<FragBean.ResultBean> list;

    public FragAdapter(Context context, List<FragBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder=new viewHolder();
        if (convertView==null){
            convertView=View.inflate(context, R.layout.fragit,null);
            holder.text = convertView.findViewById(R.id.fragitem);
        }
        holder.text.setText(list.get(position).getName());
        return convertView;
    }
    class viewHolder{
        public  TextView text;
    }
}
