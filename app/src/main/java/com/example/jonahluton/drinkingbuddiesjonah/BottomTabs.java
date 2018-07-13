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
        Tab1Chat.OnListFragmentInteractionListener,
        Tab2Destination.OnFragmentInteractionListener,
        Tab3Reviews.OnFragmentInteractionListener, Tab4Profile.OnFragmentInteractionListener,
        Tab0Group.OnFragmentInteractionListener{

    private Fragment currentFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_matching:
                    currentFragment = new Tab0Matching();
                    setFragment(currentFragment);
                    return true;

                case R.id.navigation_chat:
                    currentFragment = new Tab1Chat();
                    setFragment(currentFragment);
                    return true;

                case R.id.navigation_destination:
                    currentFragment = new Tab2Destination();
                    setFragment(currentFragment);
                    return true;

                case R.id.navigation_reviews:
                    currentFragment = new Tab3Reviews();
                    setFragment(currentFragment);
                    return true;

                case R.id.navigation_profile:
                    currentFragment = new Tab4Profile();
                    setFragment(currentFragment);
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

//    @Override
//    public void onListFragmentInteraction(DummyContent.DummyItem item) {
//
//    }

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
