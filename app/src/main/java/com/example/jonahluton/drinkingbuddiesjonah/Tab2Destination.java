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
import android.view.DragAndDropPermissions;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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

        //FILL IN NEW SUGGESTIONS WIDGET

        //Create Array of drink IDs
        List<R.id> DRINK_PIC_ID = new ArrayList<>();

        //Create Array of drink names and descriptions
        List<String> DRINK_NAME = new ArrayList<>();
        List<String> DRINK_PIC = new ArrayList<>();
        List<String> DRINK_INFO = new ArrayList<>();

        //Store IDs
        //static {
//
//            DRINK_PIC_ID.add(R.id.drink1IV);
//            DRINK_PIC_ID.add(R.id.drink2IV);
//            DRINK_PIC_ID.add(R.id.drink3IV);
//            DRINK_PIC_ID.add(R.id.drink4IV);
//            DRINK_PIC_ID.add(R.id.drink5IV);


        //}

        //Create drink names
        DRINK_NAME.add("Cappucino");
        DRINK_NAME.add("Lemon Ice Tea");
        DRINK_NAME.add("Green Tea");
        DRINK_NAME.add("Mocha");
        DRINK_NAME.add("Hot Chocolate");
        DRINK_NAME.add("Latte");
        DRINK_NAME.add("Coke");
        DRINK_NAME.add("Oolong Milk Tea");
        DRINK_NAME.add("2Mocha");
        DRINK_NAME.add("2Hot Chocolate");

        //create drink descriptions
        DRINK_INFO.add("Dark, rich espresso, topped with a layer of foamed milk");
        DRINK_INFO.add("Refreshing and zesty cold ice tea with a hint of freshly squeezed lemon");
        DRINK_INFO.add("Bitter and sweet chinese green tea");
        DRINK_INFO.add("Perfect mix of rich espresso and chocolate");
        DRINK_INFO.add("Warm and cozy drink made up of 5 different types of chocolate");
        DRINK_INFO.add("2Dark, rich espresso, topped with a layer of foamed milk");
        DRINK_INFO.add("2Refreshing and zesty cold ice tea with a hint of freshly squeezed lemon");
        DRINK_INFO.add("2Bitter and sweet chinese green tea");
        DRINK_INFO.add("2Perfect mix of rich espresso and chocolate");
        DRINK_INFO.add("2Warm and cozy drink made up of 5 different types of chocolate");
        //}

        //Randomise drink suggestions
        int[] drinkOrder = new int[5];

        for (int i = 0; i < 5; i++) {
            Random rnd = new Random();
            drinkOrder[i] = rnd.nextInt(10);
        }

        //check that numbers don't overlap
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (drinkOrder[i] == drinkOrder[j] &&  i != j) {
                    Random rnd = new Random();
                    drinkOrder[i] = rnd.nextInt(10);
                }
            }
        }

        //Create random ratings
        float[] drinkRatings = new float[5];

        for (int i = 0; i < 5; i++) {
            Random rnd = new Random();
            drinkRatings[i] = rnd.nextFloat() * 5;

        }
        //Place info in layout
        for (int i = 0; i < 5; i++) {

            int drinkID = getContext().getResources().getIdentifier("drink" + (i+1) +"TV", "id", getContext().getPackageName());
            TextView DrinkName = (TextView) destinationView.findViewById(drinkID);

            int infoID = getContext().getResources().getIdentifier("description" + (i+1) +"TV", "id", getContext().getPackageName());
            TextView DrinkInfo = (TextView) destinationView.findViewById(infoID);

            int rateID = getContext().getResources().getIdentifier("rate" + (i+1) +"Bar", "id", getContext().getPackageName());
            RatingBar DrinkRate = (RatingBar) destinationView.findViewById(rateID);

            DrinkName.setText(DRINK_NAME.get(drinkOrder[i]));
            DrinkInfo.setText(DRINK_INFO.get(drinkOrder[i]));
            DrinkRate.setRating(drinkRatings[i]);


        }

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
