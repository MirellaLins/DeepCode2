package com.domain.deepcode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.CursorAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    Retrofit config = new Retrofit.Builder()
            .baseUrl("https://professor-allocation.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private CursoService createCourseService() {
        return config.create(CursoService.class);
    }

    private CourseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView recyclerView = findViewById(R.id.rvCursos);

        adapter = new CourseAdapter();

        recyclerView.setAdapter(adapter);

        executarGetAll();

    }


    private void executarGetAll() {
        createCourseService().getAllCourses().enqueue(
                new Callback<List<CoursesRes>>() {
                    @Override
                    public void onResponse(Call<List<CoursesRes>> call, Response<List<CoursesRes>> response) {
                        List<CoursesRes> cursos = response.body();
                        adapter.setCursos(cursos);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<List<CoursesRes>> call, Throwable t) {
                        // 500, 503
                        Log.e(MainActivity.class.getSimpleName(), "Error");
                    }
                });
    }
}