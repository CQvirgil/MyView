package com.example.banner;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Banner banner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        banner = findViewById(R.id.banner);
        List<Integer> banner_item = new ArrayList<>();
        banner_item.add(R.drawable.test_img4);
        banner_item.add(R.drawable.test_img1);
        banner_item.add(R.drawable.test_img2);
        banner_item.add(R.drawable.test_img3);
        banner_item.add(R.drawable.test_img4);
        banner_item.add(R.drawable.test_img1);
        BannerAdapter adapter = new BannerAdapter(banner_item, this);
        banner.setAdapter(adapter);
    }
}
