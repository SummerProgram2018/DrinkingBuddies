package com.example.jonahluton.drinkingbuddiesjonah;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab4Profile.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab4Profile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab0Matching extends Fragment {

    private FindFields f;

    public Tab0Matching() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() == null){
            f = new FindFields();

        } else {
            f = new Gson().fromJson((String) getArguments().get("FIND_FIELDS"), FindFields.class);
        }
        Toast.makeText(getContext().getApplicationContext(), f.toString(),
                Toast.LENGTH_LONG).show();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab0_matching, container, false);

        TextView request = v.findViewById(R.id.request);
        request.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Tab0MatchingRequests newTab = new Tab0MatchingRequests();
                launchTab(newTab);
            }
        });

        TextView group = v.findViewById(R.id.group);
        group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tab0Group newTab = new Tab0Group();
                launchTab(newTab);
            }
        });

        TextView drink = v.findViewById(R.id.drink);
        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tab0TypeOfDrink newTab = new Tab0TypeOfDrink();
                launchTab(newTab);
            }
        });

        TextView range = v.findViewById(R.id.range);
        range.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tab0Range newTab = new Tab0Range();
                launchTab(newTab);
            }
        });

        Button find = v.findViewById(R.id.button2);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(enoughVariables()){
                    search();
                } else {
                    Toast.makeText(getContext().getApplicationContext(), "you're missing variabls",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        return v;
    }

    public void launchTab(Fragment frag){
        Bundle bun = new Bundle();
        bun.putString("FIND_FIELDS", new Gson().toJson(f));
        frag.setArguments(bun);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction bob = manager.beginTransaction();
        bob.replace(R.id.content, frag)
                .commit();
    }
    private void search(){
        //TODO actually search
    }

    private boolean enoughVariables(){
        if (f.getGroupSize() == 0){
            return false;
        }
        if(f.getRange() == 0){
            return false;
        }
        if(f.drinks.size() == 0){
            return false;
        }
        return true;
    }


}