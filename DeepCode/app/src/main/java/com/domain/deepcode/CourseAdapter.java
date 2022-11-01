package com.domain.deepcode;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseHolder> {

    private List<CoursesRes> cursos = new ArrayList<>();

    public void setCursos(List<CoursesRes> cursos) {
        this.cursos = cursos;
    }

    @NonNull
    @Override
    public CourseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout_course, parent, false);

        return new CourseHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseHolder holder, int position) {
        CoursesRes curso = cursos.get(position);
        holder.configureItem(curso);
    }

    @Override
    public int getItemCount() {
        return cursos.size();
    }
}
