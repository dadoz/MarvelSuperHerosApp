package com.application.dev.david.marvelsuperherosapp.data.local;

import com.application.dev.david.marvelsuperherosapp.data.SuperHeroesDataSource;
import com.application.dev.david.marvelsuperherosapp.models.SuperHero;

import java.util.List;
import io.reactivex.Observable;

@Local
public class LocalSuperHeroesStorage implements SuperHeroesDataSource {

    public LocalSuperHeroesStorage() {

    }

    @Override
    public Observable<List<SuperHero>> getSuperHeroes() {
        return null;
    }

    @Override
    public boolean hasSuperHeroes() {
        return false;
    }

    @Override
    public void addSuperHeroes(List<SuperHero> list) {

    }
}
