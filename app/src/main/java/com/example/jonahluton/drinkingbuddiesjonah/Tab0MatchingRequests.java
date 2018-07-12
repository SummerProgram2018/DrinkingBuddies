package com.example.jonahluton.drinkingbuddiesjonah;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab0MatchingRequests extends Fragment {

    private FindFields f;


    public Tab0MatchingRequests() {
        // Required empty public constructor
    }


    @Override
    public void onCreate (Bundle bundle){
        super.onCreate(bundle);

        if (getArguments() == null){
            f = new FindFields();
        } else {
            f = new Gson().fromJson((String) getArguments().get("FIND_FIELDS"), FindFields.class);
        }

        Toast.makeText(getContext().getApplicationContext(), f.getGroupSize() + " " + f.getRange() + ' ' + f.drinks,
                Toast.LENGTH_LONG).show();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab0_matching_requests, container, false);
    }

}