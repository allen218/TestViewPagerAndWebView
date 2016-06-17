package com.example.mac.testviewpagerandwebview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by allen on 16/6/16.
 */
public class NormalpagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mListFragment;
    private String[] mTitles;

    public NormalpagerAdapter(FragmentManager fm, List<Fragment> listFragment, String[] titles) {
        super(fm);
        this.mListFragment = listFragment;
        this.mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mListFragment.get(position);
    }

    @Override
    public int getCount() {
        return mListFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
