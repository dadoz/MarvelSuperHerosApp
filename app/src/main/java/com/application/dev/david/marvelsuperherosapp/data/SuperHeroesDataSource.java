package com.application.dev.david.marvelsuperherosapp.data;



import java.util.List;

import io.reactivex.Observable;

public interface SuperHeroesDataSource {
    Observable<List<String>> getSuperHeroes(int position);

    boolean hasSuperHeroes(int position);

    void addSuperHeroes(List<String> list);

}
