package com.example.jonahluton.drinkingbuddiesjonah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (isStoredToken()){
            //TODO login and launch bottomTabs
        } else {
            //TODO launch sign in / up page with new intent
            Intent myIntent  = new Intent(); //TODO give params
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
