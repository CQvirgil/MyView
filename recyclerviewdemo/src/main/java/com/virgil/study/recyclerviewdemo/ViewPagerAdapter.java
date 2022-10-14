package com.virgil.study.recyclerviewdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> item;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> item) {
        super(fm);
        this.item = item;
    }

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return item.get(i);
    }

    @Override
    public int getCount() {
        return item.size();
    }
}
