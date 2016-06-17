package com.example.mac.testviewpagerandwebview;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.view_pager)
    CustomViewPager mViewPager;

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {

        List<Fragment> fragmentList = initFragment();

        String[] titles = initTitle();

        mViewPager.setAdapter(new NormalpagerAdapter(getSupportFragmentManager(), fragmentList, titles));
        mViewPager.setPagerNum(fragmentList.size());
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private String[] initTitle() {
        return new String[]{"title1", "title2", "title3", "title4", "title5", "title6", "title7"};
    }

    private List<Fragment> initFragment() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new NormalFragment());
        fragments.add(new NormalFragment());
        fragments.add(new NormalFragment());
        fragments.add(new NormalFragment());
        fragments.add(new NormalFragment());
        fragments.add(new NormalFragment());
        fragments.add(new NormalFragment());
        return fragments;
    }
}
