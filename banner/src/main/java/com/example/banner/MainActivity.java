package com.example.banner;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        banner.setCarousel(true);
        banner.setNavPointColor(Color.parseColor("#1E90FF"));
        banner.setTime(20000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        banner.setCarousel(true);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        banner.setCarousel(false);
    }
}
