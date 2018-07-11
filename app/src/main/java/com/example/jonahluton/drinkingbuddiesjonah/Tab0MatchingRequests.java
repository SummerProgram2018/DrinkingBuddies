package com.example.jonahluton.drinkingbuddiesjonah;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab0MatchingRequests.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab0MatchingRequests#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab0MatchingRequests extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Bundle bundle;

    private OnFragmentInteractionListener mListener;

    public Tab0MatchingRequests() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
            bundle = getArguments();
        } else {
            bundle = new Bundle();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab0_matching_requests, container, false);

        View p1 = v.findViewById(R.id.p1);
        p1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                returnValue(1);
            }
        });

        View p2 = v.findViewById(R.id.p2);
        p2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                returnValue(2);
            }
        });

        View p3 = v.findViewById(R.id.p3);
        p3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                returnValue(3);
            }
        });

        View p4 = v.findViewById(R.id.p4);
        p4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                returnValue(4);
            }
        });

        View p5 = v.findViewById(R.id.p5);
        p5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                returnValue(5);
            }
        });

        View p6 = v.findViewById(R.id.p6);
        p6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                returnValue(6);
            }
        });
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

    private void returnValue(int i){
        bundle.putInt("numberOfPeople", i);
        Tab0Matching newTab = new Tab0Matching();
        newTab.setArguments(bundle);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction bob = manager.beginTransaction();
        bob.replace(R.id.content, newTab)
                .commit();
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
