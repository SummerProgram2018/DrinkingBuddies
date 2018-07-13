package com.example.jonahluton.drinkingbuddiesjonah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jonahluton.drinkingbuddiesjonah.utils.SharedPrefsUtil;


public class EditProfile extends AppCompatActivity implements View.OnClickListener{
    private Button button_cancel;
    private Button button_save;
    private EditText editText_name;
    private EditText editText_dis;
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
        editText_name = (EditText) findViewById(R.id.editText_name);
        editText_dis = (EditText) findViewById(R.id.editText_dis);
    }
    public static final String action = "login.action";

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_cancel:
                finish();
                break;
            case R.id.button_save:
                String name =editText_name.getText().toString();
                String dis =editText_dis.getText().toString();
                SharedPrefsUtil.putStringValue(this,"name",name);
                SharedPrefsUtil.putStringValue(this,"dis",dis);
                finish();
                break;
            default:
                break;
        }
    }
}

