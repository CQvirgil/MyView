package com.example.viewtest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.viewtest.UI.RollTextView;

public class RollViewHodler extends RecyclerView.ViewHolder {
    RollTextView vRollText;

    public RollViewHodler(@NonNull View itemView) {
        super(itemView);
        vRollText = itemView.findViewById(R.id.item_roll_text);
        vRollText.setText("asdasdasdasdasdasdasdasdasdasd");
    }
}
