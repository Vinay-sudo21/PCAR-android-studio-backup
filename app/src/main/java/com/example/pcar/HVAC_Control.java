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

import java.util.ArrayList;
import java.util.List;

public class HVAC_Control extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hvac_control);

        // Find the Spinner by its ID
        Spinner spinnerDropdown = findViewById(R.id.spinnerDropdown);
        ImageView logoutIcon = findViewById(R.id.logoutIcon);
        ImageView profileIcon = findViewById(R.id.profileIcon);

        // Create a list of values
        List<String> spinnerValues = new ArrayList<>();
        spinnerValues.add("15");
        spinnerValues.add("20");
        spinnerValues.add("25");
        spinnerValues.add("30");

        // Create an ArrayAdapter using the list and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                spinnerValues
        );

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinnerDropdown.setAdapter(adapter);

        // Set click listener for the logout icon
        logoutIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for the logout icon
                Intent loginIntent = new Intent(HVAC_Control.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        // Set click listener for the profile icon
        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for the profile icon
                Intent profileIntent = new Intent(HVAC_Control.this, ProfileActivity.class);
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
                Toast.makeText(HVAC_Control.this, "This service is currently unavailable", Toast.LENGTH_LONG).show();
            }
        });
    }
}
