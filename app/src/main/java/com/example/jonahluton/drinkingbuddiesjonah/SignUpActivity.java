package com.example.jonahluton.drinkingbuddiesjonah;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * A login screen that offers login via email/password.
 */
public class SignUpActivity extends AppCompatActivity {

    private boolean emailOK(){
        EditText temp  = findViewById(R.id.email);
        String email = temp.getText().toString();

        return email.contains("@");
    }

    private boolean passOK(){
        EditText temp1 = findViewById(R.id.pass);
        String pass = temp1.getText().toString();
        EditText temp2 = findViewById(R.id.repass);
        String rePass = temp2.getText().toString();

        return pass.equals(rePass) && pass.length() > 4;
    }

    private boolean idOK(){
        return true; //TODO impliment
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(emailOK() && passOK() && idOK())) {
                    Toast.makeText(getBaseContext().getApplicationContext(), "please enter everything validly",
                            Toast.LENGTH_LONG).show();
                } else {
                    EditText temp = findViewById(R.id.email);
                    String email = temp.getText().toString();
                    EditText temp2 = findViewById(R.id.pass);
                    String pass = temp2.getText().toString();
                    EditText temp3 = findViewById(R.id.citNum);
                    String id = temp3.getText().toString();

                    ///////////////////////////////////////////////////////////////////////////////////////////////
                    // TODO writing stuff
                    String entry = email + ',' + pass + ',' + id + System.getProperty("line.separator");

                    File file = new File(Environment.getExternalStorageDirectory() + File.separator + "Users.csv");
                    if (! file.exists()){
                        try {
                            file.createNewFile();
                        } catch (IOException e) {
                            Toast.makeText(getBaseContext().getApplicationContext(), "No new file for you",
                                    Toast.LENGTH_LONG).show();
                            e.printStackTrace();
                            return;
                        }
                    }

                    try {
                        FileOutputStream fOut = openFileOutput("Users.csv", MODE_APPEND);
                        OutputStreamWriter osw = new OutputStreamWriter(fOut);

                        osw.write(entry);

                        osw.flush();
                        osw.close();
                    } catch (IOException e) {
                        Toast.makeText(getBaseContext().getApplicationContext(), "failked to  write",
                                Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                        return;
                    }

                    launchSignUp();
                }
            }
        });



    }

    private void launchSignUp(){
        Intent intent = new Intent(getBaseContext(), LoginActivity.class);
        startActivity(intent);
    }
}

