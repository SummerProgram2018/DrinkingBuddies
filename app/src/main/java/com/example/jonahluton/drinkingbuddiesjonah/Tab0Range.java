package com.example.jonahluton.drinkingbuddiesjonah;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab0Range extends Fragment {

    private View v;
    private FindFields f;

    public Tab0Range() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);

        if (getArguments() == null){
            f = new FindFields();
        } else {
            FindFields jsonJavaRootObject = new Gson().fromJson(getArguments().get("FINDFIELDS"), FindFields.class);
            //f = (FindFields) getArguments().get("FINDFIELDS");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_tab0_range, container, false);

        Button button = v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText text = v.findViewById(R.id.range);
                String var = text.getText().toString();
                if(!var.equals("")){
                    try {
                        f.setRange(Integer.parseInt(var));
                        //TODO start the things
                        Bundle bundle = new Bundle();
                        Tab0Matching newTab = new Tab0Matching();
                        //bundle.put(); //TODO
                        //newTab.setArguments("FIND_FIELDS", f);
                        FragmentManager manager = getFragmentManager();
                        FragmentTransaction bob = manager.beginTransaction();
                        bob.replace(R.id.content, newTab).commit();
                    } catch(ClassCastException e) {
                        Toast.makeText(getContext().getApplicationContext(), "range needs to be a number",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getContext().getApplicationContext(), "please enter a range",
                            Toast.LENGTH_LONG).show();
                }
            }
        });


        return v;
    }

}
