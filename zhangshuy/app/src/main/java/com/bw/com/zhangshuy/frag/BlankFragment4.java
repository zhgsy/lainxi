package com.bw.com.zhangshuy.frag;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;


import com.bw.com.zhangshuy.R;
import com.bw.com.zhangshuy.base.BaseFragment;
import com.bw.com.zhangshuy.frag.fra.Fra01;
import com.bw.com.zhangshuy.frag.fra.Fra02;

import java.util.ArrayList;

public class BlankFragment4 extends BaseFragment {
    private ViewPager pagelayout;
    private ArrayList<Fragment> list = new ArrayList<>();
    String[] titles = new String[]{"最新","热门","我的"};
    private TabLayout tablelayout;

    @Override
    protected void initview(View view) {
        pagelayout = view.findViewById(R.id.pager_layout);
        tablelayout = view.findViewById(R.id.table_layout);
    }

    @Override
    protected void initData() {
        Fra01 fra01=new Fra01();
        Fra02 fra02=new Fra02();
        list.add(fra01);
        list.add(fra02);
        for (int i=0;i<titles.length;i++){

            tablelayout.addTab(tablelayout.newTab());
        }
        tablelayout.setupWithViewPager(pagelayout,false);
        pagelayout.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

         for(int i=0;i<titles.length;i++){
            tablelayout.getTabAt(i).setText(titles[i]);
        }
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_blank_fragment4;
    }
}
