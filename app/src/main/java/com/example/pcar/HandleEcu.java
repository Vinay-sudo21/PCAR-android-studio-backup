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

import java.util.Arrays;
import java.util.List;

public class HandleEcu extends AppCompatActivity {
    private Spinner spinnerDropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_ecu);

        spinnerDropdown = findViewById(R.id.spinnerDropdown);
        ImageView logoutIcon = findViewById(R.id.logoutIcon);
        ImageView profileIcon = findViewById(R.id.profileIcon);

        // Create a list of items
        List<String> ecuOptions = Arrays.asList("10", "20", "30", "40");

        // Create a custom adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                ecuOptions
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
                Intent loginIntent = new Intent(HandleEcu.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        // Set click listener for the profile icon
        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for the profile icon
                Intent profileIntent = new Intent(HandleEcu.this, ProfileActivity.class);
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
                Toast.makeText(HandleEcu.this, "This service is currently unavailable", Toast.LENGTH_LONG).show();
            }
        });
    }
}
