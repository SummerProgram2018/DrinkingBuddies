package com.example.jonahluton.drinkingbuddiesjonah;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Tab3ShowReviews extends AppCompatActivity implements View.OnClickListener, Tab4Profile.OnFragmentInteractionListener{
    private android.support.v4.app.Fragment currentFragment;
    private Button button_return;
    private Button button_confirm;
    private TextView rating1;
    private TextView rating2;
    private TextView rating3;
    private TextView rating4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_reviews);
        initView();
    }

    private  void initView(){
        button_return = (Button)findViewById(R.id.button_return);
        button_return.setOnClickListener(this);
        button_confirm = (Button)findViewById(R.id.button_confirm);
        button_confirm.setOnClickListener(this);
        Bundle b = getIntent().getExtras();
        int value1 = -1;
        int value2 = -1;
        int value3 = -1;
        int value4 = -1;// or other values
        if(b != null) {
            value1 = b.getInt("key1");
            value2 = b.getInt("key2");
            value3 = b.getInt("key3");
            value4 = b.getInt("key4");
        }
        rating1  = (TextView) findViewById(R.id.rating_1);
        rating1.setText( "" + value1);

        rating2  = (TextView) findViewById(R.id.rating_2);
        rating2.setText( "" + value2);

        rating3  = (TextView) findViewById(R.id.rating_3);
        rating3.setText( "" + value3);

        rating4  = (TextView) findViewById(R.id.rating_4);
        rating4.setText( "" + value4);

//        button_save = (Button)findViewById(R.id.button_save);
//        button_save.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_return:
                finish();
             break;

            case R.id.button_confirm:

                //finish();

//                FragmentTransaction fragmentTransaction;
//                FragmentManager fragmentManager;
//
//                Class fragmentClass=null;
//                Fragment mFragment;
//
//                Notes notes_fragment;  // fragment instance of current fragment
//
//                fragmentTransaction = getSupportFragmentManager().beginTransaction();
//
//                mFragment = new Tab4Profile();
//
//                setFragment(mFragment);
//                // CreateNewNote is fragment you want to display
//
//                fragmentTransaction.replace(R.id.content_fragment, mFragment);  // content_fragment is id of FrameLayout(XML file) where fragment will be displayed
//
//                fragmentTransaction.addToBackStack(frag_no); //add fragment to stack
//                fragmentTransaction.hide(currentFragment).commit();

                Tab4Profile newTab = new Tab4Profile();
                Bundle args = new Bundle();
                View v = view.findViewById(R.id.frameLayout);

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                fragmentTransaction.replace(R.id.frameLayout, newTab);
                fragmentTransaction.commit();

                button_return.setVisibility(View.INVISIBLE);
                button_confirm.setVisibility(View.INVISIBLE);
                break;
            default:
                break;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
