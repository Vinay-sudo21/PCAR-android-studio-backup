package com.example.pcar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class DoorLockEcu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door_lock_ecu);

        ImageView logoutIcon = findViewById(R.id.logoutIcon);
        ImageView profileIcon = findViewById(R.id.profileIcon);

        // Find the Spinners by their IDs
        Spinner spinnerDropdownFDR = findViewById(R.id.spinnerDropdownFDR);
        Spinner spinnerDropdownFDL = findViewById(R.id.spinnerDropdownFDL);
        Spinner spinnerDropdownRDR = findViewById(R.id.spinnerDropdownRDR);
        Spinner spinnerDropdownRDL = findViewById(R.id.spinnerDropdownRDL);

        // Create an array of values
        String[] lockUnlockValues = {"Lock", "Unlock"};

        // Create an ArrayAdapter with the array of values
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                lockUnlockValues
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the adapter for each Spinner
        spinnerDropdownFDR.setAdapter(adapter);
        spinnerDropdownFDL.setAdapter(adapter);
        spinnerDropdownRDR.setAdapter(adapter);
        spinnerDropdownRDL.setAdapter(adapter);

        logoutIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for the logout icon
                Intent loginIntent = new Intent(DoorLockEcu.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        // Set click listener for the profile icon
        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for the profile icon
                Intent profileIntent = new Intent(DoorLockEcu.this, ProfileActivity.class);
                startActivity(profileIntent);
            }
        });

        // Find Clear and Save buttons
        Button clearButton = findViewById(R.id.clear);
        Button saveButton = findViewById(R.id.save);

        // Set click listeners
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement clear functionality if needed
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Show a message saying "This service is currently unavailable"
                Toast.makeText(DoorLockEcu.this, "This service is currently unavailable", Toast.LENGTH_LONG).show();
            }
        });
    }
}
