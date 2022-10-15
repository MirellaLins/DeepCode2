package com.domain.deepcode;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VersionAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private ArrayList<String> versionNameList = new ArrayList<>();

    public void setVersionNameList(ArrayList<String> list) {
        this.versionNameList.addAll(list);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        ItemViewHolder holder = new ItemViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        String versionName = this.versionNameList.get(position);
        holder.changeText(versionName);

    }

    @Override
    public int getItemCount() {
        return versionNameList.size();
    }
}
