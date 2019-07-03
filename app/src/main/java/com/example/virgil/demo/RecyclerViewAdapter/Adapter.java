package com.example.virgil.demo.RecyclerViewAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.virgil.demo.MainActivity;
import com.example.virgil.demo.R;
import com.example.virgil.demo.Util.Tools;

public class Adapter extends RecyclerView.Adapter<ViewHodler> {
    private Context context;

    public Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);
        ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
        layoutParams.width = Tools.get().getWindowWidth(context)/2 - Tools.get().dp2px(15,context);
        ViewHodler hodler = new ViewHodler(itemView);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, int i) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
