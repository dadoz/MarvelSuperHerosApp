package com.application.dev.david.marvelsuperherosapp.data;



import com.application.dev.david.marvelsuperherosapp.models.SuperHero;

import java.util.List;

import io.reactivex.Observable;

public interface SuperHeroesDataSource {
    Observable<List<SuperHero>> getSuperHeroes();

    boolean hasSuperHeroes();

    void addSuperHeroes(List<SuperHero> list);

}
