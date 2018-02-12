package com.example.android.tvguide.model;

/**
 * Created by Wa'el Ahmad on 2/10/2018.
 */
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieAPI {
    private static final String BASE_URL = "http://api.themoviedb.org/3/";

    public static APICommunication MovieAPI() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(APICommunication.class);
    }
}

