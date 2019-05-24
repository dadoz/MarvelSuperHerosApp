package com.application.dev.david.marvelsuperherosapp.data;

import com.application.dev.david.marvelsuperherosapp.data.local.Local;
import com.application.dev.david.marvelsuperherosapp.data.remote.Remote;
import com.application.dev.david.marvelsuperherosapp.models.SuperHero;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SuperHeroesRepository {

    private final SuperHeroesDataSource remoteDataSource;
    private final SuperHeroesDataSource localDataSource;

    public SuperHeroesRepository(@Remote SuperHeroesDataSource remoteDataSource, @Local SuperHeroesDataSource localDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public Observable<List<SuperHero>> getSuperHeroes() {
        if (localDataSource.hasSuperHeroes()) {
            return localDataSource.getSuperHeroes();
        }

        return Observable.just("")
                .subscribeOn(Schedulers.newThread())
                .flatMap(index -> remoteDataSource.getSuperHeroes()
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnNext(localDataSource::addSuperHeroes))
                .subscribeOn(Schedulers.newThread());
    }

}
