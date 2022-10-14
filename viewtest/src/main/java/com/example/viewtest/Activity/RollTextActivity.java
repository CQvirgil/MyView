package com.example.viewtest.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.viewtest.R;
import com.example.viewtest.RollAdapter;
import com.example.viewtest.UI.RollTextView;

public class RollTextActivity extends AppCompatActivity {
    RollTextView bannerText;
    RecyclerView vRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_text);
        bannerText = findViewById(R.id.banner_text);
        vRecyclerView = findViewById(R.id.act_roll_text_recycler);
        bannerText.setText("温馨提示：1、本机支持医保、公医、自费患者挂号，暂时仅支持自费患者缴费 2、医保、公医患者缴费请到人工窗口办理。3、本机暂不支持住院预交金缴费。4、本机暂不支持体检缴费。");
        vRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        vRecyclerView.setAdapter(new RollAdapter());
    }
}
