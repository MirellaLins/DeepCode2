package com.domain.deepcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    private Button btExecutar;
    private Button btRequestID;
    private EditText edNomeCurso;
    private EditText edIdCurso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btExecutar = findViewById(R.id.btExecutar);
        btRequestID = findViewById(R.id.btRequestID);
        edNomeCurso = findViewById(R.id.edNomeCurso);
        edIdCurso = findViewById(R.id.edIdCurso);
        Button btOpenList = findViewById(R.id.btOpenList);

        btOpenList.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        });

        btExecutar.setOnClickListener(view -> {
            String nomeCurso = edNomeCurso.getText().toString();

            createCourse(nomeCurso);
        });

        btRequestID.setOnClickListener(view -> {
            String idCurso = edIdCurso.getText().toString();
            int id = Integer.parseInt(idCurso);
            depeteByID(id);
        });

    }

    private void atualizarCurso() {

        CourseReq updateObject = new CourseReq();
        updateObject.setName("Android - Curso editado!");

        createCourseService().updateCourse(3215, updateObject).enqueue(new Callback<CoursesRes>() {
            @Override
            public void onResponse(Call<CoursesRes> call, Response<CoursesRes> response) {
                CoursesRes newCourse = response.body();

                Log.i(MainActivity.class.getSimpleName(),
                        "Sucesso: " + newCourse.getId()
                                + " " + newCourse.getName());
            }

            @Override
            public void onFailure(Call<CoursesRes> call, Throwable t) {
                Log.e(MainActivity.class.getSimpleName(), "Error create");
            }
        });

    }

    private void depeteByID(int id) {

        createCourseService().deleteByIdCourse(id).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

                Log.i(MainActivity.class.getSimpleName(), "Curso deletado com sucesso!");
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e(MainActivity.class.getSimpleName(), "Error create");
            }
        });

    }

    private void getCourseByID() {

        createCourseService().getCourse(2055).enqueue(new Callback<CoursesRes>() {
            @Override
            public void onResponse(Call<CoursesRes> call, Response<CoursesRes> response) {
                CoursesRes newCourse = response.body();

                Log.i(MainActivity.class.getSimpleName(),
                        "Sucesso: " + newCourse.getId()
                                + " " + newCourse.getName());
            }

            @Override
            public void onFailure(Call<CoursesRes> call, Throwable t) {
                Log.e(MainActivity.class.getSimpleName(), "Error create");
            }
        });

    }

    private void createCourse(String name) {
        CourseReq newCourse = new CourseReq();
        newCourse.setName(name);

        createCourseService().createCourse(newCourse).enqueue(new Callback<CoursesRes>() {
            @Override
            public void onResponse(Call<CoursesRes> call, Response<CoursesRes> response) {
                CoursesRes newCourse = response.body();

                Log.i(MainActivity.class.getSimpleName(),
                        "Sucesso: " + newCourse.getId()
                                + " " + newCourse.getName());

                Toast.makeText(getApplicationContext(), "Sucesso!", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<CoursesRes> call, Throwable t) {
                Log.e(MainActivity.class.getSimpleName(), "Error create");
            }
        });
    }

}