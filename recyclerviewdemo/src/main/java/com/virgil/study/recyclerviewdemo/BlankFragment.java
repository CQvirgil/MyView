package com.virgil.study.recyclerviewdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements addItem {
    RecyclerViewAdapter adapter;
    RecyclerView recyclerview;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        recyclerview = view.findViewById(R.id.recyclerview);
        List<String> item = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            item.add("item " + i);
        }
        adapter = new RecyclerViewAdapter(item, getContext());
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int postition) {
                Toast.makeText(getContext(), "item "+postition, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerview.setAdapter(adapter);
        return view;
    }

    @Override
    public void add(String str) {
        adapter.addItem(str);
    }
}
