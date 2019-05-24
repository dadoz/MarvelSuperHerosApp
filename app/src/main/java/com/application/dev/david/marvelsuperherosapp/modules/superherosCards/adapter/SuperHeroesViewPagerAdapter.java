package com.application.dev.david.marvelsuperherosapp.modules.superherosCards.adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.dev.david.marvelsuperherosapp.R;
import com.application.dev.david.marvelsuperherosapp.models.SuperHero;

import java.util.List;

public class SuperHeroesViewPagerAdapter extends PagerAdapter {

        private List<SuperHero> items;

        public SuperHeroesViewPagerAdapter(List items) {
            this.items = items;
        }

        @Override
        public Object instantiateItem(@NonNull ViewGroup collection, int position) {
            LayoutInflater inflater = LayoutInflater.from(collection.getContext());
            ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.super_heroes_item_view, collection, false);
            collection.addView(layout);
            return layout;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object view) {
            container.removeView((View) view);
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
    }