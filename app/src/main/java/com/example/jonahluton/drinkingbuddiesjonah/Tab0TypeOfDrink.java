package com.example.jonahluton.drinkingbuddiesjonah;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab0TypeOfDrink extends Fragment {

    private FindFields f;


    public Tab0TypeOfDrink() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);

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
        View v = inflater.inflate(R.layout.fragment_tab0_type_of_drink, container, false);

        View a = v.findViewById(R.id.A);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f.drinks.add("A");
                launchTab();
            }
        });

        View na = v.findViewById(R.id.NA);
        na.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f.drinks.add("NA");
                launchTab();
            }
        });

        View c = v.findViewById(R.id.C);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f.drinks = new ArrayList<>();
                launchTab();
            }
        });
        return v;
    }

    private void launchTab(){
        Bundle bundle = new Bundle();

        bundle.putString("FIND_FIELDS", new Gson().toJson(f));
        Tab0Matching newTab = new Tab0Matching();
        newTab.setArguments(bundle);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction bob = manager.beginTransaction();
        bob.replace(R.id.content, newTab)
                .commit();
    }
}