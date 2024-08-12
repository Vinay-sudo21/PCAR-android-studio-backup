package com.example.pcar;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BiometricECU extends AppCompatActivity {
    private EditText editTextDSV;
    private EditText editTextDSH;
    private EditText editTextDSR;
    private Button saveButton;
    private Button clearButton;
    private TextView userLocation;
    private TextView dateTime;
    private String latitude;
    private String longitude;
    private ApiService apiService;

    private FusedLocationProviderClient fusedLocationClient;
    private LocationRequest locationRequest;
    private LocationCallback locationCallback;

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biometric_ecu);

        apiService = ApiClient.getRetrofitInstance().create(ApiService.class);

        editTextDSV = findViewById(R.id.editTextDSV);
        editTextDSH = findViewById(R.id.editTextDSH);
        editTextDSR = findViewById(R.id.editTextDSR);
        userLocation = findViewById(R.id.userLocation);
        dateTime = findViewById(R.id.dateTime);

        clearButton = findViewById(R.id.clear);
        saveButton = findViewById(R.id.save);

        clearButton.setOnClickListener(v -> clearFields());
        saveButton.setOnClickListener(v -> saveSeat());

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        locationRequest = LocationRequest.create()
                .setInterval(10000)
                .setFastestInterval(5000)
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    if (location != null) {
                        updateLocationUI(location);
                    }
                }
            }
        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
        } else {
            startLocationUpdates();
        }

        // Update the date and time every second
        updateDateTime();
    }

    private void clearFields() {
        editTextDSV.setText("");
        editTextDSH.setText("");
        editTextDSR.setText("");
    }

    private void saveSeat() {
        String dsv = editTextDSV.getText().toString().trim();
        String dsh = editTextDSH.getText().toString().trim();
        String dsr = editTextDSR.getText().toString().trim();
        String locationName = userLocation.getText().toString().trim();

        if (dsv.isEmpty() || dsh.isEmpty() || dsr.isEmpty() || locationName.equals("Location: --")) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        Seat seat = new Seat();
        seat.setDsv(dsv);
        seat.setDsh(dsh);
        seat.setDsr(dsr);
        seat.setLatitude(Double.parseDouble(latitude));
        seat.setLongitude(Double.parseDouble(longitude));
        seat.setLocationName(locationName);

        // Get the current date and time
        String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
        seat.setDateTime(currentDateTime);

        Call<Seat> call = apiService.saveSeat(seat);
        call.enqueue(new Callback<Seat>() {
            @Override
            public void onResponse(Call<Seat> call, Response<Seat> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(BiometricECU.this, "Seat saved successfully", Toast.LENGTH_SHORT).show();
                    clearFields();
                } else {
                    Toast.makeText(BiometricECU.this, "Failed to save seat", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Seat> call, Throwable t) {
                Toast.makeText(BiometricECU.this, "An error occurred: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null);

        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, location -> {
                    if (location != null) {
                        updateLocationUI(location);
                    }
                });
    }

    private void updateLocationUI(Location location) {
        latitude = String.valueOf(location.getLatitude());
        longitude = String.valueOf(location.getLongitude());

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            if (addresses != null && !addresses.isEmpty()) {
                String address = addresses.get(0).getAddressLine(0);
                userLocation.setText(address);
            } else {
                userLocation.setText("Unable to get location name");
            }
        } catch (IOException e) {
            userLocation.setText("Unable to get location name");
        }
    }

    private void updateDateTime() {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                String currentDateAndTime = sdf.format(new Date());
                dateTime.setText(currentDateAndTime);

                handler.postDelayed(this, 1000);
            }
        };
        handler.post(runnable);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startLocationUpdates();
            } else {
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
