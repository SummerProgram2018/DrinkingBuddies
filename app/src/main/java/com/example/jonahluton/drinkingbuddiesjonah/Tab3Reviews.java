package com.example.jonahluton.drinkingbuddiesjonah;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import com.example.jonahluton.drinkingbuddiesjonah.dummy.DummyContent;
import com.example.jonahluton.drinkingbuddiesjonah.dummy.DummyContent.DummyItem;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab4Profile.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab4Profile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab3Reviews extends Fragment implements View.OnClickListener {

    // TODO: Customize parameter argument names
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Customize parameters
    private String mParam1;
    private String mParam2;
    private Button confirm_ratings;
    private RatingBar rate_bar1;
    private OnFragmentInteractionListener mListener;




    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public Tab3Reviews() {
    }

    // TODO: Customize parameter initialization
    public static Tab3Reviews newInstance(String param1, String param2) {
        Tab3Reviews fragment = new Tab3Reviews();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item3, container, false);
        initView(view);
        // Set the adapter
//        if (view instanceof RecyclerView) {
//            Context context = view.getContext();
//            RecyclerView recyclerView = (RecyclerView) view;
//            if (mColumnCount <= 1) {
//                recyclerView.setLayoutManager(new LinearLayoutManager(context));
//            } else {
//                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
//            }
//            recyclerView.setAdapter(new MyItemRecyclerViewAdapter3(DummyContent.ITEMS, mListener));
//        }
        return view;
    }

    private void initView(View view){
        confirm_ratings = (Button)view.findViewById(R.id.confirmRatings);
        confirm_ratings.setOnClickListener(this);

        rate_bar1= (RatingBar) view.findViewById(R.id.ratingBar1);
        rate_bar1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.confirmRatings:
                Intent intent = new Intent(getActivity(), Tab3ShowReviews.class);
                Bundle b = new Bundle();
                b.putInt("key", (int) rate_bar1.getRating()); //Your id
                intent.putExtras(b);
                startActivity(intent);

                break;
            default:
                break;
        }
    }

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
                    + " must implement OnListFragmentInteractionListener");
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
