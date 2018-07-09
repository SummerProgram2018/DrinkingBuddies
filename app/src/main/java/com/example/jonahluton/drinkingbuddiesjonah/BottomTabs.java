package com.example.jonahluton.drinkingbuddiesjonah;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.jonahluton.drinkingbuddiesjonah.dummy.DummyContent;

import com.example.jonahluton.drinkingbuddiesjonah.Tab1ChatContent;

public class BottomTabs extends AppCompatActivity implements
        Tab0Matching.OnFragmentInteractionListener,
        Tab1Chat.OnListFragmentInteractionListener,
        Tab2Destination.OnFragmentInteractionListener,
        Tab3Reviews.OnListFragmentInteractionListener, Tab4Profile.OnFragmentInteractionListener{

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_matching:
                    setFragment(new Tab0Matching());
                    return true;
                case R.id.navigation_chat:
                    setFragment(new Tab1Chat());
                    return true;
                case R.id.navigation_destination:
                    setFragment(new Tab2Destination());
                    return true;
                case R.id.navigation_reviews:
                    setFragment(new Tab3Reviews());
                    return true;
                case R.id.navigation_profile:
                    setFragment(new Tab4Profile());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_tabs);

        ((BottomNavigationView) findViewById(R.id.navigation)).
                setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setFragment(new Tab0Matching());
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private void setFragment (Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        /* TODO make animations fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left,
                R.anim.slide_in_right, R.anim.slide_out_left); */

        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onListFragmentInteraction(Tab1ChatContent.ChatItem item) {

    }
}
