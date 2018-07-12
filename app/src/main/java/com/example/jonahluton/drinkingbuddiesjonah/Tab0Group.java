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
import android.widget.Toast;

import com.google.gson.Gson;


public class Tab0Group extends Fragment {

    private FindFields f;

    public Tab0Group() {
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
        View v = inflater.inflate(R.layout.fragment_tab0_group, container, false);

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




    private void returnValue(int i){
        Bundle bundle = new Bundle();
        f.setGroupSize(i);
        bundle.putString("FIND_FIELDS", new Gson().toJson(f));
        Tab0Matching newTab = new Tab0Matching();
        newTab.setArguments(bundle);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction bob = manager.beginTransaction();
        bob.replace(R.id.content, newTab)
                .commit();
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