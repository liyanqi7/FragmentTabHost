package com.example.lyq.fragmenttabhost;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyq on 2017/8/10.
 */
public class FragmentHome extends Fragment{

    private TabLayout t1;
    private ViewPager vp;
    private List<Fragment> fragments;
    private List<String> strings;
    private View views;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        views = inflater.inflate(R.layout.fragment_home,container,false);
        inittabLayout();
        return views;
    }

    private void inittabLayout() {
        t1 = (TabLayout) views.findViewById(R.id.t1);
        vp = (ViewPager) views.findViewById(R.id.vp);
        //添加Fragment
        fragments = new ArrayList<>();
        fragments.add(new FragmentMessage());
        fragments.add(new FragmentMessage());
        fragments.add(new FragmentMessage());
        fragments.add(new FragmentMessage());
        fragments.add(new FragmentMessage());
        fragments.add(new FragmentMessage());
        fragments.add(new FragmentMessage());
        fragments.add(new FragmentMessage());
        fragments.add(new FragmentMessage());
        fragments.add(new FragmentMessage());
        fragments.add(new FragmentMessage());
        fragments.add(new FragmentMessage());
        fragments.add(new FragmentMessage());
        //添加Tab文字
        strings = new ArrayList<>();
        strings.add("推荐");
        strings.add("爱上超模");
        strings.add("电视剧");
        strings.add("电影");
        strings.add("综艺");
        strings.add("动漫");
        strings.add("订阅");
        strings.add("北京");
        strings.add("资讯");
        strings.add("娱乐");
        strings.add("搞笑");
        strings.add("儿童");
        strings.add("原创");
        //添加Tab
        for (String str : strings){
            t1.addTab(t1.newTab().setText(str));
        }
        //绑定ViewPager
        FragmentAdapter adapter = new FragmentAdapter(getFragmentManager(),fragments,strings);
        vp.setAdapter(adapter);
        t1.setupWithViewPager(vp);
    }
}
