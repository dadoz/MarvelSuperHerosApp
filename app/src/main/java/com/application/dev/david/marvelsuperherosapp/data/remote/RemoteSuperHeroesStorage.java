package com.application.dev.david.marvelsuperherosapp.data.remote;

import com.application.dev.david.marvelsuperherosapp.data.SuperHeroesDataSource;
import com.application.dev.david.marvelsuperherosapp.models.SuperHero;

import java.util.List;
import io.reactivex.Observable;

@Remote
public class RemoteSuperHeroesStorage implements SuperHeroesDataSource {

    @Override
    public Observable<List<SuperHero>> getSuperHeroes(int position) {
        return null;
    }

    @Override
    public boolean hasSuperHeroes(int position) {
        return false;
    }

    @Override
    public void addSuperHeroes(List<SuperHero> list) {
    }
}
