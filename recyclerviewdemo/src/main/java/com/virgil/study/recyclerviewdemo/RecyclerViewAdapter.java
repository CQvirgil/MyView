package com.virgil.study.recyclerviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<mViewHodle> implements View.OnClickListener {
    List<String> item;
    Context context;
    OnItemClickListener listener;

    public RecyclerViewAdapter(List<String> item, Context context) {
        this.item = item;
        this.context = context;
    }

    public void addItem(String str){
        item.add(0,str);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public mViewHodle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        view.setOnClickListener(this);
        mViewHodle viewHodle = new mViewHodle(view);
        return viewHodle;
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHodle holder, int position) {
        holder.setItemText(item.get(position));
        holder.setTag(position);
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    @Override
    public void onClick(View v) {
        listener.onItemClick(v,  Integer.parseInt(v.getTag().toString()) );
        //Toast.makeText(context, ""+v.getTag(), Toast.LENGTH_SHORT).show();
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    interface OnItemClickListener{
        void onItemClick(View v, int postition);
    }
}
