package com.example.pcar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @POST("seats")
    Call<Seat> saveSeat(@Body Seat seat);

    @GET("seats")
    Call<List<Seat>> getSeats();
}
