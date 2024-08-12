package com.example.pcar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Find the LOGIN button
        Button loginButton = findViewById(R.id.login);
        final EditText editUserName = findViewById(R.id.editUserName);
        final EditText editUserPass = findViewById(R.id.editUserPass);

        // Set a click listener for the LOGIN button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editUserName.getText().toString();
                String password = editUserPass.getText().toString();
                if (validateCredentials(username, password)) {
                    // Create an Intent to navigate to the DashboardActivity
                    Intent dashboardIntent = new Intent(LoginActivity.this, Dashboard.class);
                    // Start the DashboardActivity
                    startActivity(dashboardIntent);
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                } else {
                    // Show error message
                    Toast.makeText(LoginActivity.this, "Incorrect Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Find the "Register here" link TextView
        TextView registerLink = findViewById(R.id.registerLink);

        // Set a click listener for the "Register here" link
        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the RegisterActivity
                Intent registerIntent = new Intent(LoginActivity.this, RegisterPage.class);
                // Start the RegisterActivity
                startActivity(registerIntent);
            }
        });
    }

    private boolean validateCredentials(String username, String password) {
        // Predefined usernames and passwords
        if ((username.equals("vinay") && password.equals("vinay123")) ||
                (username.equals("varaprasad") && password.equals("vara123")) ||
                (username.equals("ramdas") && password.equals("ram123"))) {
            return true;
        }
        return false;
    }
}
