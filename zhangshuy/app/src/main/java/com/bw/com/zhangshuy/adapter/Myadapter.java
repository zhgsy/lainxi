package com.bw.com.zhangshuy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.com.zhangshuy.R;
import com.bw.com.zhangshuy.bean.Bean;
import com.bw.com.zhangshuy.utils.HttpWorkUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Myadapter extends BaseAdapter {
    final int TYPE0=0;
    final int TYPE1=1;
    Context context;
    List<Bean.ResultBean> list;

    public Myadapter(Context context, List<Bean.ResultBean> list) {
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
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                return TYPE0;
            case 1:
                return TYPE1;
        }
        return position%2;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder=null;
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type){
                case TYPE0:
                    convertView = View.inflate(context, R.layout.item, null);
                    holder=new viewHolder();
                    holder.image = convertView.findViewById(R.id.imageview1);
                    holder.text = convertView.findViewById(R.id.textt);
                    convertView.setTag(holder);
                    break;
                case TYPE1:
               convertView=View.inflate(context,R.layout.item_layout,null);
                    holder=new viewHolder();
                    holder.te1 = convertView.findViewById(R.id.te1);
                    holder.te2 = convertView.findViewById(R.id.te2);
                convertView.setTag(holder);
                break;
            }

        }else{
            holder= (viewHolder) convertView.getTag();
        }
        switch (type){
            case  TYPE0:
                holder.text.setText(list.get(position).getName());
                ImageLoader.getInstance().displayImage(list.get(position).getImageUrl(),holder.image);
                break;
            case TYPE1:
                holder.te1.setText(list.get(position).getSummary());
             /*   holder.te2.setText(list.get(position).getId());*/
                break;
        }

        return convertView;
    }


    class viewHolder {
        public ImageView image;
        public TextView text;
        public TextView te1;
        public TextView te2;

    }
   /* */
}