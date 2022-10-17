package com.domain.deepcode;


import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


public class ItemViewHolder extends RecyclerView.ViewHolder {

    private TextView tvVersionName;
    private ConstraintLayout clContainer;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        tvVersionName = itemView.findViewById(R.id.tvVersionName);
        clContainer = itemView.findViewById(R.id.clContainerParent);

    }

    public void changeText(String value) {
        tvVersionName.setText(value);
    }

    public void changeBackgroundColor(String color) {

        clContainer.setBackgroundColor(Color.parseColor(color));

    }

}
