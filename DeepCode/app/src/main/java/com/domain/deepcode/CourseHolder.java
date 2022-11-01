package com.domain.deepcode;

import android.media.Image;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CourseHolder extends RecyclerView.ViewHolder {

    private TextView tvID, tvName;
    private ImageView ivEdit;

    public CourseHolder(@NonNull View itemView) {
        super(itemView);

        tvID = itemView.findViewById(R.id.tvIdCourse);
        tvName = itemView.findViewById(R.id.tvNameCourse);
        ivEdit = itemView.findViewById(R.id.ivEdit);
    }

    public void configureItem(CoursesRes curso) {

        tvID.setText(String.valueOf(curso.getId()));
        tvName.setText(curso.getName());

        ivEdit.setOnClickListener(view -> {
            Log.i(">>>", "Click item " + curso.getName());
            Toast.makeText(itemView.getContext(), curso.getName(), Toast.LENGTH_LONG).show();
        });

    }

}
