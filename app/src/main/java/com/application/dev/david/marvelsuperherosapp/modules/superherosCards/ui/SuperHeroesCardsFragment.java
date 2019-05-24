package com.application.dev.david.marvelsuperherosapp.modules.superherosCards.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.dev.david.marvelsuperherosapp.R;
import com.application.dev.david.marvelsuperherosapp.data.SuperHeroesRepository;
import com.application.dev.david.marvelsuperherosapp.data.local.LocalSuperHeroesStorage;
import com.application.dev.david.marvelsuperherosapp.data.remote.RemoteSuperHeroesStorage;
import com.application.dev.david.marvelsuperherosapp.models.SuperHero;
import com.application.dev.david.marvelsuperherosapp.modules.superherosCards.ColorGridPresenter;
import com.application.dev.david.marvelsuperherosapp.modules.superherosCards.SuperHeroesView;

import java.util.List;

import butterknife.ButterKnife;

public class SuperHeroesCardsFragment extends Fragment implements SuperHeroesView {
    private ColorGridPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.super_heroes_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new ColorGridPresenter(this,
                new SuperHeroesRepository(new RemoteSuperHeroesStorage(), new LocalSuperHeroesStorage()));
        onInitView();
    }

    /**
     * init view
     */
    private void onInitView() {
        presenter.retrieveData();
    }

    @Override
    public void onSuperHeroesRetrieved(List<SuperHero> list) {
    }

    @Override
    public void onSuperHeroesError(String error) {
    }
}
