package com.application.dev.david.marvelsuperherosapp.data.remote;

import com.application.dev.david.marvelsuperherosapp.data.SuperHeroesDataSource;
import com.application.dev.david.marvelsuperherosapp.data.remote.services.RetrofitServiceRx;
import com.application.dev.david.marvelsuperherosapp.data.remote.services.SuperHeroesService;
import com.application.dev.david.marvelsuperherosapp.models.SuperHero;

import java.util.List;
import io.reactivex.Observable;

@Remote
public class RemoteSuperHeroesStorage implements SuperHeroesDataSource {


    private final SuperHeroesService superHeroesService;

    public RemoteSuperHeroesStorage() {
        superHeroesService = new RetrofitServiceRx().getSuperHeroesService();
    }

    @Override
    public Observable<List<SuperHero>> getSuperHeroes() {
        return superHeroesService.retrieveSuperHeroes();
    }

    @Override
    public boolean hasSuperHeroes() {
        return false;
    }

    @Override
    public void addSuperHeroes(List<SuperHero> list) {
    }
}
