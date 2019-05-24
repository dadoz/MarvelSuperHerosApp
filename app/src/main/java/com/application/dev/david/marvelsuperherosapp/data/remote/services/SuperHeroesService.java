package com.application.dev.david.marvelsuperherosapp.data.remote.services;



import com.application.dev.david.marvelsuperherosapp.models.SuperHero;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface SuperHeroesService {
    @GET("bla/bla")
    Observable<List<SuperHero>> retrieveSuperHeroes();
}
