package com.virgil.study.recyclerviewdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BlankFragment2 extends Fragment implements View.OnClickListener {
    addItem addItem;
    public BlankFragment2() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static BlankFragment2 newInstance() {
        BlankFragment2 fragment = new BlankFragment2();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        Button btn = view.findViewById(R.id.btn_add_item);
        btn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void setAddItem(com.virgil.study.recyclerviewdemo.addItem addItem) {
        this.addItem = addItem;
    }

    @Override
    public void onClick(View v) {
        addItem.add("additem");
    }
}
