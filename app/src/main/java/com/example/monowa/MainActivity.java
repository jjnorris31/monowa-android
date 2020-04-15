package com.example.monowa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public SharedPreferences preferences;
    private TextView user;
    private TextView pass;
    private Button signIn;
    private Button signUp;
    private String extraUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        preferences = getSharedPreferences("sp", Context.MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logIn(View view) {
        /*user = findViewById(R.id.username);
        pass = findViewById(R.id.pass);*/
        String userStr = user.getText().toString();
        String userPass = pass.getText().toString();
        boolean validUser = preferences.getBoolean("USER_" + userStr + "_" + userPass, false);
        if (validUser) {
            Toast usrToast = Toast.makeText(this, "Welcome again!", Toast.LENGTH_SHORT);
            usrToast.show();
            Intent timerIntent = new Intent(this, Timer.class);
            startActivity(timerIntent);
        } else {
            Toast usrToast = Toast.makeText(this, "Cannot login!", Toast.LENGTH_SHORT);
            pass.setText("");
            usrToast.show();
        }
    }

    /**
     * Method that allows the user register in the app
     * @param view the login view
     */
    public void goToLogIn(View view) {
        Intent loginIntent = new Intent(this, Login.class);
        startActivity(loginIntent);
    }

    public void goToSignUp(View view) {
        Intent signUp = new Intent(this, SignUp.class);
        startActivity(signUp);
    }
}
