package com.example.pcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Find the ECU card views
        CardView acCard = findViewById(R.id.acCard);
        CardView chairCard = findViewById(R.id.chairCard);
        CardView doorCard = findViewById(R.id.doorCard);
        CardView mirrorCard = findViewById(R.id.mirrorCard);
        CardView handleCard = findViewById(R.id.handleCard);
        ImageView logoutIcon = findViewById(R.id.logoutIcon);
        ImageView profileIcon = findViewById(R.id.profileIcon);
        // Set click listeners for each ECU card
        acCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for the AC ECU card
                // You can start the AC activity or perform any action here
//                startAcActivity(HandleEcu());
                Intent hvacEcu = new Intent(Dashboard.this, HVAC_Control.class);
                startActivity(hvacEcu);
            }
        });

        chairCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for the Chair ECU card
                // You can start the Chair activity or perform any action here
                // Example: startChairActivity();
                Intent bioEcu = new Intent(Dashboard.this, BiometricECU.class);
                startActivity(bioEcu);
            }
        });

        doorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for the Door ECU card
                // You can start the Door activity or perform any action here
                // Example: startDoorActivity();
                Intent doorEcu = new Intent(Dashboard.this, DoorLockEcu.class);
                startActivity(doorEcu);
            }
        });

        mirrorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for the Mirror ECU card
                // You can start the Mirror activity or perform any action here
                // Example: startMirrorActivity();
                Intent mirrorEcu = new Intent(Dashboard.this, MirrorECU.class);
                startActivity(mirrorEcu);
            }
        });

        handleCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for the Handle ECU card
                // You can start the Handle activity or perform any action here
                // Example: startHandleActivity();
                Intent handleEcu = new Intent(Dashboard.this, HandleEcu.class);
                startActivity(handleEcu);
            }
        });

        // Set click listener for the logout icon
        logoutIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for the logout icon
                // You can navigate to the login page or perform any other logout action
                // Example: navigateToLoginActivity();
                Intent loginIntent = new Intent(Dashboard.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        // Set click listener for the profile icon
        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for the profile icon
                // You can navigate to the profile activity or perform any other profile-related action
                // Example: navigateToProfileActivity();
                Intent profileIntent = new Intent(Dashboard.this, ProfileActivity.class);
                startActivity(profileIntent);

            }
        });
    }
}
