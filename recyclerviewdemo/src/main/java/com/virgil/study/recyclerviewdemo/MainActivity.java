package com.virgil.study.recyclerviewdemo;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewpager);
        List<Fragment> item = new ArrayList<>();
        final BlankFragment fragment1 = new BlankFragment();
        BlankFragment2 fragment2 = new BlankFragment2();
        fragment2.setAddItem(new addItem() {
            @Override
            public void add(String str) {
                fragment1.add(str);
            }
        });
        item.add(fragment1);
        item.add(fragment2);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),item);
        viewPager.setAdapter(adapter);
    }
}
