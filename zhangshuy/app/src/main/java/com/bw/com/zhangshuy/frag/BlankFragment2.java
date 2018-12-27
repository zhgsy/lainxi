package com.bw.com.zhangshuy.frag;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.telephony.mbms.MbmsErrors;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.com.zhangshuy.R;
import com.bw.com.zhangshuy.base.BaseFragment;
import com.bw.com.zhangshuy.frag.fra.Fra01;
import com.bw.com.zhangshuy.frag.fra.Fra02;
import com.bw.com.zhangshuy.frag.fra.Frag_03;

import java.util.ArrayList;


public class BlankFragment2 extends BaseFragment {

    private ViewPager pagelayout;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private String[] titles = new String[]{"最新","热门","我的"};
    private TabLayout tablelayout;
    @Override
    protected void initview(View view) {
        pagelayout = view.findViewById(R.id.pager_layout);
        tablelayout = view.findViewById(R.id.table_layout);
    }

    @Override
    protected void initData() {
        final Fra01 fra01=new Fra01();
        Fra02 fra02=new Fra02();
        fragments.add(fra01);
        fragments.add(fra02);
        for (int i=0;i<titles.length;i++){

            tablelayout.addTab(tablelayout.newTab());
        }
        tablelayout.setupWithViewPager(pagelayout,false);
        pagelayout.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

     /*   for(int i=0;i<titles.length;i++){

            tablelayout.getTabAt(i).setText(titles[i]);
        }*/
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_blank_fragment2;
    }

}
