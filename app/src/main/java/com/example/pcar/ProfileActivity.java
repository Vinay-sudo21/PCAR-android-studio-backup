package com.example.pcar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView logoutIcon = findViewById(R.id.logoutIcon);

        // Set click listeners for the logout and profile icons
        logoutIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for the logout icon
                // You can navigate to the login page or perform any other logout action
                // Example: navigateToLoginActivity();
                Intent loginIntent = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}