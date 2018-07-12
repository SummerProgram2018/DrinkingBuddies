package com.example.jonahluton.drinkingbuddiesjonah;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< Updated upstream
import android.widget.Toast;

import com.google.gson.Gson;
=======
>>>>>>> Stashed changes


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab0TypeOfDrink extends Fragment {

<<<<<<< Updated upstream
    private FindFields f;

=======
>>>>>>> Stashed changes

    public Tab0TypeOfDrink() {
        // Required empty public constructor
    }

<<<<<<< Updated upstream
    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);

        if (getArguments() == null){
            f = new FindFields();
        } else {
            f = new Gson().fromJson((String) getArguments().get("FIND_FIELDS"), FindFields.class);
        }

        Toast.makeText(getContext().getApplicationContext(), f.getGroupSize() + " " + f.getRange() + ' ' + f.drinks,
                Toast.LENGTH_LONG).show();
    }
=======
>>>>>>> Stashed changes

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab0_type_of_drink, container, false);



        return v;
    }

}
