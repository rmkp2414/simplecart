package com.apiit.api;

import com.apiit.model.Product;
import com.apiit.model.User;
import java.util.List;
import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("/api/users")
    Call<User> getUsers();

    @GET("/api/unknown/{id}")
    Call<Product> getProductById(@Query("id") int id);

    @GET("/api/get")
    Call<Product> getProductById();

    @GET("/products")
    Call<List<Product>> getProducts();

//    @GET("/users.json")
//    void getProducts(Callback<List<Product>> cb);
//    @GET("/users.json")
//    Call<List<Contacts>> getContacts();
//    @GET("/api/unknown/")
//    Call<Product> getProductsByCategory(@Query("cat") String cat);
    @GET("/products")
    Call<Product> getProductsByCategory(@Query("cat") String cat);

//    @POST("/api/login")
//    abstract public Call<User> loginUser();

//    @POST("/api/login")
//    public abstract Call<LoginResponse> login(@Query("email") String email, @Query("password") String password);

//    @POST("/api/login")
//    Call<LoginResponse> login(@Query("email") String email, @Query("password") String password);

    @FormUrlEncoded
    @POST("/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @FormUrlEncoded
    @POST("users/")
    Call<RegisterResponse> registerUsers(@Body RegisterRequest registerRequest);


    /////////////////////////////////////////////NEW///////////////////////////
//    @POST("/api/login")
//    Call<LoginResponse> login(@Query("email") String email, @Query("password") String password);

    @Headers({"Content-Type: application/json"})
    @POST("/api/authenticate")
    Call<LoginResponse> login(@Body LoginRequest login);

    @Headers({"Content-Type: application/json"})
    @POST("/api/user")
    Call<User> getUser(@Header("Authorization") String authToken);

    @Headers({"Content-Type: application/json"})
    @POST("/api/register")
    Call<RegisterResponse> register(@Body RegisterRequest register);

    @Headers({"Content-Type: application/json"})
    @GET("/api/hello")
    Call<String> sayHello();

    @Headers({"Content-Type: application/json"})
    @GET("/api/products")
    Call<List<Product>> getAllProducts(@Header("Authorization") String authToken);
//    Call<String> getAllProducts(@Header("Authorization") String authToken);

    @Headers({"Content-Type: application/json"})
    @POST("/api/saveshipping")
    Call<GeneralResponse> saveShipping(@Header("Authorization") String authToken,@Body ShippingOrder order);

}
