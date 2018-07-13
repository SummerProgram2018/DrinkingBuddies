package com.example.jonahluton.drinkingbuddiesjonah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Tab3ShowReviews extends AppCompatActivity implements View.OnClickListener{
    private Button button_return;
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
//            case R.id.button_save:
//                finish();
//                break;
            default:
                break;
        }
    }
}
