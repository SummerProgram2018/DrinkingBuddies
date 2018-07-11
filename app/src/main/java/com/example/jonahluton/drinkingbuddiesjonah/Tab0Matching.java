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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab4Profile.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab4Profile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab0Matching extends Fragment { // TODO is this implementation neccesary??

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Bundle bundle;
    private OnFragmentInteractionListener mListener;

    public Tab0Matching() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab4Profile.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab0Matching newInstance(String param1, String param2) {
        Tab0Matching fragment = new Tab0Matching();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null){
            bundle = getArguments();
        } else {
            bundle = new Bundle();
        }
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
                //TODO neeed to make this do shit
            }
        });
        return v;
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
