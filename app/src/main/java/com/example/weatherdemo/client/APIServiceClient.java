package com.example.weatherdemo.client;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIServiceClient {
    private static APIClient apiClient;
    private static String BASE_URL = "https://opendata.cwb.gov.tw/api/";

    public static APIClient getInstance() {
        if (apiClient == null) {
            synchronized (APIServiceClient.class) {
                if (apiClient == null) {
                    new APIServiceClient();
                }
            }
        }
        return apiClient;
    }

    private APIServiceClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiClient = retrofit.create(APIClient.class);
    }
}
