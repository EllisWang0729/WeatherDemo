package com.example.weatherdemo;

import android.content.Context;

import java.util.List;

public interface MainContract {
    interface View {
        void refreshList(List<Object> list, List<CityWeatherData.Records.LocationData> locationDataList);
    }

    interface Presenter {
        void setContext(Context context);

        void callWeatherData();
    }
}
