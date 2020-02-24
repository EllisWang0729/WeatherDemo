package com.example.weatherdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View, WeatherAdapter.OnItemClickListener {
    @BindView(R.id.recycler)
    RecyclerView rvWeather;

    private MainContract.Presenter mainPrenter;
    private WeatherAdapter weatherAdapter;
    private List<CityWeatherData.Records.LocationData> orgLocationDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();

        mainPrenter.callWeatherData();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (SharedPrefUtil.isFirstCome(this)) {
            SharedPrefUtil.setFirstCome(this, false);
        } else {
            Toast.makeText(this, getString(R.string.text_welcome_back), Toast.LENGTH_SHORT).show();
        }
    }

    private void initView() {
        mainPrenter = new MainPrenter(this);
        mainPrenter.setContext(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvWeather.setLayoutManager(linearLayoutManager);
        weatherAdapter = new WeatherAdapter(this, new ArrayList<Object>());
        weatherAdapter.setOnItemClickListener(this);
        rvWeather.setAdapter(weatherAdapter);

    }

    @Override
    public void refreshList(List<Object> list, List<CityWeatherData.Records.LocationData> locationDataList) {
        orgLocationDataList = locationDataList;
        weatherAdapter.upDateItem(list);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.e("dddd", new Gson().toJson(orgLocationDataList.get(position)));
        Intent intent = new Intent(this, WeatherDetailActivity.class);
        intent.putExtra("Weather", orgLocationDataList.get(position));
        startActivity(intent);
    }
}
