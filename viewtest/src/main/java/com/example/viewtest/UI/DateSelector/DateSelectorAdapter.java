package com.example.viewtest.UI.DateSelector;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewtest.R;

import java.util.List;

public class DateSelectorAdapter extends RecyclerView.Adapter<DateSelectorViewHolder> {
    List<DateBean> list;
    private Context context;

    public DateSelectorAdapter(List<DateBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DateSelectorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_date, viewGroup, false);
        return new DateSelectorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DateSelectorViewHolder dateSelectorViewHolder, int i) {
        dateSelectorViewHolder.setDate(list.get(i).getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
