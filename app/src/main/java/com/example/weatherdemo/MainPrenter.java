package com.example.weatherdemo;

import android.content.Context;
import android.util.Log;

import com.example.weatherdemo.client.APIServiceClient;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPrenter implements MainContract.Presenter {
    private static final String MINTFILTER = "MinT";
    private MainContract.View mView;
    private Context mContext;

    MainPrenter(MainContract.View view) {
        this.mView = view;
    }

    @Override
    public void setContext(Context context) {
        this.mContext = context;

    }

    @Override
    public void callWeatherData() {
        APIServiceClient.getInstance().cityWeather(mContext.getString(R.string.weather_token)).enqueue(new Callback<CityWeatherData>() {
            @Override
            public void onResponse(Call<CityWeatherData> call, Response<CityWeatherData> response) {
                Log.e("sssss", new Gson().toJson(response));
                if ("true".equals(response.body().getSuccess())) {
                    parserData(response.body());
                }
            }

            @Override
            public void onFailure(Call<CityWeatherData> call, Throwable t) {
                Log.e("sssss", t.getMessage());
            }
        });
    }

    private void parserData(CityWeatherData data) {
        if (data.getRecords() == null || data.getRecords().getLocation() == null) {
            return;
        }
        List<Object> finishList = new ArrayList<>();
        List<CityWeatherData.Records.LocationData> locationDataList = data.getRecords().getLocation();
        for (int i = 0; i < locationDataList.size(); i++) {
            for (int j = 0; j < locationDataList.get(i).getWeatherElement().size(); j++) {
                if (MINTFILTER.equals(locationDataList.get(i).getWeatherElement().get(j).getElementName())) {
                    for (int k = 0; k < locationDataList.get(i).getWeatherElement().get(j).getTime().size(); k++) {
                        finishList.add(String.format("%s\n%s\n%s\n%s",
                                k==0?locationDataList.get(i).getLocationName():"",
                                locationDataList.get(i).getWeatherElement().get(j).getTime().get(k).getStartTime(),
                                locationDataList.get(i).getWeatherElement().get(j).getTime().get(k).getEndTime(),
                                locationDataList.get(i).getWeatherElement().get(j).getTime().get(k).getParameter().getParameterName() +
                                        locationDataList.get(i).getWeatherElement().get(j).getTime().get(k).getParameter().getParameterUnit()));
                    }
                }
            }
            finishList.add(mContext.getDrawable(R.mipmap.ic_launcher_round));
        }
        mView.refreshList(finishList,locationDataList);
    }
}
