package com.application.dev.david.marvelsuperherosapp;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.application.dev.david.marvelsuperherosapp.modules.superherosCards.SuperHeroesCardsFragment;
import com.application.dev.david.marvelsuperherosapp.modules.superherosLike.SuperHeroesLikeListFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(item -> {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        loadFragment(new SuperHeroesCardsFragment());
                        return true;
                    case R.id.navigation_dashboard:
                        loadFragment(new SuperHeroesLikeListFragment());
                        return true;
                    case R.id.navigation_notifications:
                    default:
                        return true;
                }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //unbind views
    }

    /**
     *
     * @param fragment
     */
    protected void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.superhFragmentContainerId, fragment);
        transaction.commit();
    }

}
