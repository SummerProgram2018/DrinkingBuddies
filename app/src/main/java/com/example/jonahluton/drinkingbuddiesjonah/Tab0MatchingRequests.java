package com.example.jonahluton.drinkingbuddiesjonah;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;
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
    public void onCreate(Bundle bun){
        super.onCreate(bun);

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
        View v = inflater.inflate(R.layout.fragment_tab0_matching_requests, container, false);


        ScrollView sv = v.findViewById(R.id.sv);

        // Create a LinearLayout element
        LinearLayout ll = new LinearLayout(v.getContext());
        ll.setOrientation(LinearLayout.VERTICAL);

        // Add text
        TextView tv = new TextView(ll.getContext());
        tv.setText("my text");
        ll.addView(tv);

        // Add the LinearLayout element to the ScrollView
        //sv.addView(ll);

        // Display the view
        //setContentView(v);


        return v;
    }

}