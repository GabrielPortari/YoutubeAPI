package com.example.youtubeclone.helper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfiguration {

    public static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(YoutubeConfiguration.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
