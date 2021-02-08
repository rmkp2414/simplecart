package com.apiit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
//public static final String BASE_URL = "https://reqres.in/";
//public static final String BASE_URL = "https://fakestoreapi.com";
public static final String BASE_URL = "http://192.168.1.4:8080/api/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}