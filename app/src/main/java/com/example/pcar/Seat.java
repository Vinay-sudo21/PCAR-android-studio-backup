package com.example.pcar;

public class Seat {
    private String dsv;
    private String dsh;
    private String dsr;
    private double latitude;
    private double longitude;
    private String locationName;
    private String dateTime; // New field for date and time

    // Getters and setters for all fields
    public String getDsv() {
        return dsv;
    }

    public void setDsv(String dsv) {
        this.dsv = dsv;
    }

    public String getDsh() {
        return dsh;
    }

    public void setDsh(String dsh) {
        this.dsh = dsh;
    }

    public String getDsr() {
        return dsr;
    }

    public void setDsr(String dsr) {
        this.dsr = dsr;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
