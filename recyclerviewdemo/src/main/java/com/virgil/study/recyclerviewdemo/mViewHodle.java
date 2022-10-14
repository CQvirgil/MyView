package com.virgil.study.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class mViewHodle extends RecyclerView.ViewHolder {
    TextView textView;
    View itemView;
    public mViewHodle(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.item_text);
        this.itemView = itemView;
    }

    public void setTag(int postition){
        itemView.setTag(postition);
    }

    public void setItemText(String text){
        textView.setText(text);
    }
}
