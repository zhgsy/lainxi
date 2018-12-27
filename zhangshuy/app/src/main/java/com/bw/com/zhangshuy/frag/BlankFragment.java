package com.bw.com.zhangshuy.frag;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RadioGroup;

import com.bw.com.zhangshuy.R;
import com.bw.com.zhangshuy.base.BaseFragment;
import com.bw.com.zhangshuy.frag.fra.Frag_01;
import com.bw.com.zhangshuy.frag.fra.Frag_02;
import com.bw.com.zhangshuy.frag.fra.Frag_03;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends BaseFragment {
    private RadioGroup radiogroup;
    private ViewPager pager;

    @Override
    protected void initview(View view) {
        radiogroup = view.findViewById(R.id.tradio);
        pager = view.findViewById(R.id.pager);
    }

    @Override
    protected void initData() {
        final ArrayList<Fragment> list=new ArrayList<>();
        Frag_01 frag_01=new Frag_01();
        Frag_02 frag_02=new Frag_02();
        Frag_03 frag_03=new Frag_03();
        list.add(frag_01);
        list.add(frag_02);
        list.add(frag_03);
        pager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        radiogroup.check(radiogroup.getChildAt(0).getId());
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                radiogroup.check(radiogroup.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.bbun1:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.bbun2:
                        pager.setCurrentItem(1);
                        break;
                    case  R.id.bbun3:
                        pager.setCurrentItem(2);
                        break;
                }
            }
        });
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_blank;
    }
/*

    @Override
    protected View initview() {
        View view=View.inflate(getActivity(),,null);

        return view;
    }*/
}
