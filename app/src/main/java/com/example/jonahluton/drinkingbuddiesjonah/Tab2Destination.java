package com.example.jonahluton.drinkingbuddiesjonah;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab2Destination.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab2Destination#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab2Destination extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Tab2Destination() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab2Destination.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab2Destination newInstance(String param1, String param2) {
        Tab2Destination fragment = new Tab2Destination();
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
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_tab2_destination, container, false);

        //For reference to use findViewById and return value
        View destinationView = inflater.inflate(R.layout.fragment_tab2_destination, container, false);

        //Arrive Button Click functionality
        final Button arriveBtn = (Button) destinationView.findViewById(R.id.arriveBtnID);

        final TextView arriveStat = (TextView) destinationView.findViewById(R.id.arriveStatTxtView);

        arriveBtn.setOnClickListener(new View.OnClickListener() {
//            Todo: Update arrive stat
            @Override
            public void onClick(View v) {
                arriveBtn.setText("Enjoy!");
                arriveStat.setText("1/2");
                arriveBtn.setEnabled(false);
                setRetainInstance(true);
            }
        });

        //Alert Button Click functionality
        final Button alertBtn = (Button) destinationView.findViewById(R.id.alertBtnID);

        alertBtn.setOnClickListener(new View.OnClickListener(){
//            Todo: start new fragment when alert button pressed
            @Override
            public void onClick(View v) {

                View popupView = getLayoutInflater().inflate(R.layout.fragment_confirm_alert,
                        null);

                final PopupWindow popupWindow = new PopupWindow(popupView,
                        WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.WRAP_CONTENT);

                // Example: If you have a TextView inside `popup_layout.xml`
                TextView tv = (TextView) popupView.findViewById(R.id.tv);

                tv.setText("Are you sure you want to confirm?");

                //PopupwWindow buttons
                final Button confirmBtn = (Button) popupView.findViewById(R.id.confirmBtn);
                Button confirmCancelBtn = (Button) popupView.findViewById(R.id.confirmCancelBtn);


                //confirm button functionality
                confirmBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        confirmBtn.setText("CONFIRM");
                        popupWindow.dismiss();
                        alertBtn.setEnabled(false);
                        }
                });

                //cancel button functionality
                confirmCancelBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });

                //PopupWindow layout settings:
                // If the PopupWindow should be focusable
                popupWindow.setFocusable(true);

                // If you need the PopupWindow to dismiss when when touched outside
                popupWindow.setBackgroundDrawable(new ColorDrawable());

                Transition enterTransit = new Slide();
                popupWindow.setEnterTransition(enterTransit);

                Transition exitTransit = new Slide();
                popupWindow.setExitTransition(exitTransit);

                popupWindow.setHeight(1800);
                popupWindow.setWidth(1100);

                // Using location, the PopupWindow will be displayed right under anchorView
                popupWindow.showAtLocation(v, Gravity.CENTER,
                        0, 0);


            }
        });

        return destinationView;
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
