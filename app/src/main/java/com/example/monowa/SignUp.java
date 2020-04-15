package com.example.monowa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    public SharedPreferences sharedPreferences;
    public TextView username;
    public TextView password;
    public TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreferences = getSharedPreferences("sp", Context.MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.edit_username);
        password = findViewById(R.id.edit_password);
        email = findViewById(R.id.edit_email);
    }

    public void goToSignIn(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String userPair = "USER_" +  username.getText().toString() + "_" + password.getText().toString();
        editor.putBoolean(userPair, true);
        editor.apply();

        Intent mainActivity = new Intent(this, MainActivity.class);
        mainActivity.putExtra("USER", username.getText().toString());
        Toast savedIntent = Toast.makeText(this, "¡Usuario guardado!", Toast.LENGTH_LONG);
        savedIntent.show();
        startActivity(mainActivity);
    }
}
