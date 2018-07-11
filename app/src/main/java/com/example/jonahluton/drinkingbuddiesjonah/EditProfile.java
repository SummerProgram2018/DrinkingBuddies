package com.example.jonahluton.drinkingbuddiesjonah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class EditProfile extends AppCompatActivity implements View.OnClickListener{
    private Button button_cancel;
    private Button button_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        initView();
    }

    private  void initView(){
        button_cancel = (Button)findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(this);
        button_save = (Button)findViewById(R.id.button_save);
        button_save.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_cancel:
                finish();
                break;
            case R.id.button_save:
                finish();
                break;
            default:
                break;
        }
    }
}
