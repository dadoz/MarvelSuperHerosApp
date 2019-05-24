package com.application.dev.david.marvelsuperherosapp.modules.superherosCards.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
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
import com.application.dev.david.marvelsuperherosapp.modules.superherosCards.adapter.SuperHeroesViewPagerAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SuperHeroesCardsFragment extends Fragment implements SuperHeroesView {
    private ColorGridPresenter presenter;
    @BindView(R.id.sHeroesViewPagerId)
    ViewPager sHeroesViewPager;

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
        sHeroesViewPager.setAdapter(new SuperHeroesViewPagerAdapter(list));
    }

    @Override
    public void onSuperHeroesError(String error) {
        Snackbar.make(getActivity().getWindow().getDecorView(), error, Snackbar.LENGTH_SHORT).show();
    }
}
