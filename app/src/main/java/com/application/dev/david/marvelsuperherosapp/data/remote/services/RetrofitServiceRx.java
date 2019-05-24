package com.application.dev.david.marvelsuperherosapp.data.remote.services;


import android.util.Log;

import com.application.dev.david.marvelsuperherosapp.BuildConfig;
import com.application.dev.david.marvelsuperherosapp.models.SuperHero;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceRx {
    /**
     * get service
     * @return
     */
    public SuperHeroesService getSuperHeroesService() {
        try {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            return new Retrofit.Builder()
                    .baseUrl(BuildConfig.SUPER_HEROES_BASE_URL)
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
//                            .registerTypeAdapter(new TypeToken<List<SuperHero>>(){}.getType(), new SuperHeroJsonDeserializer())
                            .create()))
                    .build()
                    .create(SuperHeroesService.class);
        } catch (Exception e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

}
