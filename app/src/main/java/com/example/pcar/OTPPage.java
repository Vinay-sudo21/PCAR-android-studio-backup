package com.example.pcar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OTPPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otppage);

        // Find the "Validate OTP" button
        Button validateOtpButton = findViewById(R.id.register);

        // Set a click listener for the "Validate OTP" button
        validateOtpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the LoginActivity
                Intent loginIntent = new Intent(OTPPage.this, LoginActivity.class);
                // Start the LoginActivity
                startActivity(loginIntent);
                Toast.makeText(OTPPage.this, "Registration Successful", Toast.LENGTH_SHORT).show();

            }
        });

        // Set up the back arrow click listener
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity to go back to the previous activity
                finish();
            }
        });
    }
}