package com.example.pcar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        // Find the REGISTER button
        Button registerButton = findViewById(R.id.register);

        // Set a click listener for the REGISTER button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the OTPActivity
                Intent otpIntent = new Intent(RegisterPage.this, OTPPage.class);
                // Start the OTPActivity
                startActivity(otpIntent);
                Toast.makeText(RegisterPage.this, "OTP has been sent to your register mobile number", Toast.LENGTH_SHORT).show();
            }
        });

        // Find the CANCEL button
        Button cancelButton = findViewById(R.id.cancel);

        // Set a click listener for the CANCEL button
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity to go back to the previous page
                finish();
            }
        });
    }
}