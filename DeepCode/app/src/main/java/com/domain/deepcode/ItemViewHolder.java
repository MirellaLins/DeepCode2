package com.domain.deepcode;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

//    ItemViewHolder holder = new ItemViewHolder(/* Construir a referencia da view */);

    private TextView tvVersionName;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        tvVersionName = itemView.findViewById(R.id.tvVersionName);

    }

    public void changeText(String value) {
        tvVersionName.setText(value);
    }

}
