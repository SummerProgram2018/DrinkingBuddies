package com.example.jonahluton.drinkingbuddiesjonah;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.jonahluton.drinkingbuddiesjonah.dummy.DummyContent;

public class BottomTabs extends AppCompatActivity implements
        Tab0Matching.OnListFragmentInteractionListener,
        Tab1Chat.OnListFragmentInteractionListener,
        Tab2Destination.OnFragmentInteractionListener,
        Tab3Reviews.OnListFragmentInteractionListener, Tab4Profile.OnFragmentInteractionListener{

    private BottomNavigationView mBottomNavigationView;
    private FrameLayout mainFrame;

    /*
    private Tab0Matching matching;
    private Tab1Chat chat;
    private Tab2Destination destination;
    private Tab3Reviews reviews;
    private Tab4Profile profile;
    private Fragment focussed;
    */







    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            setFragment(new Tab0Matching());
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

        mBottomNavigationView= (BottomNavigationView) findViewById(R.id.navigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mainFrame = (FrameLayout) findViewById(R.id.content);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private void setFragment (Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.commit();
    }
}
