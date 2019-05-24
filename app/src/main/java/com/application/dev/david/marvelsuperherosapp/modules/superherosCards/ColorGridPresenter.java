package com.application.dev.david.marvelsuperherosapp.modules.superherosCards;

import android.support.v4.util.Pair;


import com.application.dev.david.marvelsuperherosapp.data.SuperHeroesRepository;
import com.application.dev.david.marvelsuperherosapp.models.SuperHero;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ColorGridPresenter {
    private final SuperHeroesRepository respository;
    private final SuperHeroesView view;

    public ColorGridPresenter(SuperHeroesView view, SuperHeroesRepository repository) {
        this.respository = repository;
        this.view = view;
    }

    public void retrieveData() {
        Disposable disposable =
                respository.getSuperHeroes()
                                .subscribeOn(Schedulers.newThread())
                                .observeOn(AndroidSchedulers.mainThread())
                                .doOnError(Throwable::printStackTrace)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(pair -> view.onSuperHeroesRetrieved(pair),
                                error -> view.onSuperHeroesError(error.getMessage()));
    }

}
