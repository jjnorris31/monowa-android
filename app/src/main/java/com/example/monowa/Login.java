package com.example.monowa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    public SharedPreferences sharedPreferences;
    private TextView username;
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreferences = getSharedPreferences("sp", Context.MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        username = findViewById(R.id.edit_username);
        password = findViewById(R.id.edit_password);
    }

    public void logIn(View view) {
        String usernameStr = username.getText().toString();
        String passwordStr = password.getText().toString();

        boolean loginSuccess = sharedPreferences.getBoolean("USER_" + usernameStr + "_" + passwordStr, false);

        if (loginSuccess) {
            Toast toastSuccess = Toast.makeText(this, "Hi again!", Toast.LENGTH_SHORT);
            Intent activityIntent = new Intent(this, Timer.class);
            startActivity(activityIntent);
            toastSuccess.show();
        } else {
            Toast toastFail = Toast.makeText(this, "Check your credentials", Toast.LENGTH_SHORT);
            password.setText("");
            toastFail.show();
        }
    }
}
