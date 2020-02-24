package com.example.weatherdemo.client;

import com.example.weatherdemo.CityWeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIClient {

    @GET("v1/rest/datastore/F-C0032-001?")
    Call<CityWeatherData> cityWeather(@Query("Authorization") String Authorization);
}
