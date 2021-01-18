package com.apiit.api;

import com.apiit.model.Product;
import com.apiit.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("/api/users")
    Call<User> getUsers();

    @GET("/api/unknown/{id}")
    Call<Product> getProductById(@Query("id") int id);

    @GET("/api/get")
    Call<Product> getProductById();

//    @GET("/api/unknown")
//    Call<Product> getProducts();
    @GET("/products")
    Call<Product> getProducts();

//    @GET("/api/unknown/")
//    Call<Product> getProductsByCategory(@Query("cat") String cat);
@GET("/products")
Call<Product> getProductsByCategory(@Query("cat") String cat);

//    @POST("/api/login")
//    abstract public Call<User> loginUser();

//    @POST("/api/login")
//    public abstract Call<LoginResponse> login(@Query("email") String email, @Query("password") String password);

    @POST("/api/login")
    Call<LoginResponse> login(@Query("email") String email, @Query("password") String password);

    @POST("/api/register")
    Call<LoginResponse> register(
            @Query("email") String email,
            @Query("password") String password
    );
//    Call<LoginResponse> register(
//            @Query("email") String email,
//            @Query("password") String password,
//            @Query("name") String name,
//            @Query("number") String number
//    );

//    @FormUrlEncoded
//    @POST("/login")
//    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);
//
//    @POST("users/")
//    Call<RegisterResponse> registerUsers(@Body RegisterRequest registerRequest);
}
