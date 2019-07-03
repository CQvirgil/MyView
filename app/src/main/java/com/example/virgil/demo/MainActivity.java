package com.example.virgil.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.virgil.demo.RecyclerViewAdapter.Adapter;
import com.example.virgil.demo.Util.Tools;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setRecyclerView();
        Log.i("testlog",Tools.get().getWindowWidth(this)+"");
        Log.i("testlog",Tools.get().dp2px(20,this)+"");
    }

    private void initView(){
        recyclerView = findViewById(R.id.main_recyclerview);
    }

    private void setRecyclerView(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(new Adapter(this));
    }
}
