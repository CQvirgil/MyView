package com.example.viewtest.UI.DateSelector;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.viewtest.R;

public class DateSelectorViewHolder extends RecyclerView.ViewHolder {
    private TextView tvDate;
    public DateSelectorViewHolder(@NonNull View itemView) {
        super(itemView);
        tvDate = itemView.findViewById(R.id.item_date);
    }

    public void setDate(String strDate){
        tvDate.setText(strDate);
    }
}
