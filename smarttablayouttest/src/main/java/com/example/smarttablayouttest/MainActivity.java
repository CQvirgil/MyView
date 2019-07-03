package com.example.smarttablayouttest;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewpager);
        smartTabLayout = findViewById(R.id.smart_tab);

        List<Fragment> fragments = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for(int i = 0; i<20;i++){
            fragments.add(BlankFragment.newInstance());
            titles.add(i+"");
        }
        Adapter adapter = new Adapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);
    }
}
