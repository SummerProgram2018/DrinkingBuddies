package com.example.jonahluton.drinkingbuddiesjonah;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
