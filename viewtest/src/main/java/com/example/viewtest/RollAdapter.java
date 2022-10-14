package com.example.viewtest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class RollAdapter extends RecyclerView.Adapter<RollViewHodler> {

    @NonNull
    @Override
    public RollViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        return new RollViewHodler(inflater.inflate(R.layout.item_roll_text, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RollViewHodler rollViewHodler, int i) {

    }

    @Override
    public int getItemCount() {
        return 50;
    }
}
