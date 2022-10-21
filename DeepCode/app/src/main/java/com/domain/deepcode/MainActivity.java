package com.domain.deepcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Retrofit config = new Retrofit.Builder()
            .baseUrl("https://professor-allocation.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private CursoService createCourseService() {
        return config.create(CursoService.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createCourseService().getAllCourses().enqueue(
                new Callback<List<CoursesRes>>() {
            @Override
            public void onResponse(Call<List<CoursesRes>> call, Response<List<CoursesRes>> response) {
                // 400, 404, 401, 200, 201, 204 ......
                List<CoursesRes> cursos = response.body();
                for (CoursesRes item : cursos) {
                    Log.i(MainActivity.class.getSimpleName(), item.getName());
                }
            }

            @Override
            public void onFailure(Call<List<CoursesRes>> call, Throwable t) {
                // 500, 503
                Log.i(MainActivity.class.getSimpleName(), "Erro");
            }
        });

    }
}