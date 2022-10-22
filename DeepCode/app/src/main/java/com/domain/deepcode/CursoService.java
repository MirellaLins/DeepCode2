package com.domain.deepcode;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CursoService {

    @GET("/courses")
    Call<List<CoursesRes>> getAllCourses();

    @GET("/courses/{course_id}")
    Call<CoursesRes> getCourse(@Path("course_id") int id);

    @POST("/courses")
    Call<CoursesRes> createCourse(@Body CourseReq course);

    // Não executar!!!!!!!!!!!!
//    @DELETE("/courses/")
//    Call deleteAllCourses();

    @PUT("/courses/{course_id}")
    Call<CoursesRes> updateCourse(@Path("course_id") int id, @Body CourseReq course);

    @DELETE("/courses/{course_id}")
    Call<Object> deleteByIdCourse(@Path("course_id") int id);



//    @PUT("/courses/{course_id}")
//    Call<CoursesRes> updateCourse(@Field("name") RequestBody name, @Path("course_id") Long id);

}
