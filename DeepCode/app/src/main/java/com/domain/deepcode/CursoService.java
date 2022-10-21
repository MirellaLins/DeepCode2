package com.domain.deepcode;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CursoService {

    @GET("/courses")
    Call<List<CoursesRes>> getAllCourses();

    @GET("/courses/{course_id}")
    Call<CoursesRes> getCourse(@Path("course_id") Long id);

    @POST("/courses")
    Call<CoursesRes> createCourse(@Body CourseReq course);

    // Não executar!!!!!!!!!!!!
//    @DELETE("/courses/")
//    Call deleteAllCourses();

    @PUT("/courses/{course_id}")
    Call<CoursesRes> updateCourse(@Path("course_id") Long id, @Body CourseReq course);

    @DELETE("/courses/{course_id}")
    Call deleteByIdCourse(@Path("course_id") Long id);



//    @PUT("/courses/{course_id}")
//    Call<CoursesRes> updateCourse(@Field("name") RequestBody name, @Path("course_id") Long id);

}
