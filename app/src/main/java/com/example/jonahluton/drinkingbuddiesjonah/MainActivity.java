package com.example.jonahluton.drinkingbuddiesjonah;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.example.jonahluton.drinkingbuddiesjonah.utils.SharedPrefsUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPrefsUtil.clearValue(this,"name");
        SharedPrefsUtil.clearValue(this,"dis");



        requestPermission(this);
        if (isStoredToken()){

            //launch bottom tabs
            Intent intent = new Intent(getBaseContext(), BottomTabs.class);
            startActivity(intent);
        } else {


            //launch login activity
            Intent intent  = new Intent(getBaseContext(), LoginActivity.class);// changed to get base context
            startActivity(intent);
            finish();
        }


    }

    private void requestPermission(Activity context) {
        boolean hasPermission = (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
        if (!hasPermission) {
            ActivityCompat.requestPermissions(context,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    512);
        }
    }
    private boolean isStoredToken(){
        //TODO
        return false;
    }

    private class Token{
        //TODO
        public String username;
        public String password;
    }

    private Token getToken(){
        //TODO
        Token result = null;
        return result;
    }
}
