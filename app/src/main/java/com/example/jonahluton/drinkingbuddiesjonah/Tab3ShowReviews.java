package com.example.jonahluton.drinkingbuddiesjonah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Tab3ShowReviews extends AppCompatActivity implements View.OnClickListener{
    private Button button_return;
    private TextView rating1;



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
        int value = -1; // or other values
        if(b != null) {
            value = b.getInt("key");
        }
        rating1  = (TextView) findViewById(R.id.rating_1);
        rating1.setText( "" + value);

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
