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

    private Bundle bundle;
    private OnFragmentInteractionListener mListener;
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
            this.bundle = savedInstanceState;
            System.out.println(getArguments().get("FIND_FIELDS"));
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
                newTab.setArguments(bundle);
                FragmentManager manager = getFragmentManager();
                FragmentTransaction bob = manager.beginTransaction();
                bob.replace(R.id.content, newTab)
                        .commit();
            }
        });

        TextView group = v.findViewById(R.id.group);
        group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tab0Group newTab = new Tab0Group();
                newTab.setArguments(bundle);
                FragmentManager manager = getFragmentManager();
                FragmentTransaction bob = manager.beginTransaction();
                bob.replace(R.id.content, newTab)
                        .commit();
            }
        });

        TextView drink = v.findViewById(R.id.drink);
        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tab0TypeOfDrink newTab = new Tab0TypeOfDrink();
                newTab.setArguments(bundle);
                FragmentManager manager = getFragmentManager();
                FragmentTransaction bob = manager.beginTransaction();
                bob.replace(R.id.content, newTab)
                        .commit();
            }
        });

        TextView range = v.findViewById(R.id.range);
        range.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tab0Range newTab = new Tab0Range();
                newTab.setArguments(bundle);
                FragmentManager manager = getFragmentManager();
                FragmentTransaction bob = manager.beginTransaction();
                bob.replace(R.id.content, newTab)
                        .commit();
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
