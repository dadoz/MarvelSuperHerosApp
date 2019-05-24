package com.application.dev.david.marvelsuperherosapp.modules.superherosCards;

import com.application.dev.david.marvelsuperherosapp.models.SuperHero;

import java.util.List;

public interface SuperHeroesView {
    void onSuperHeroesRetrieved(List<SuperHero> list);
    void onSuperHeroesError(String error);

}
