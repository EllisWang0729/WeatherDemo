package com.example.weatherdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherDetailActivity extends AppCompatActivity {
    @BindView(R.id.tv_info)
    TextView tvInfo;

    private static final String MINTFILTER = "MinT";
    private CityWeatherData.Records.LocationData locationData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_detail);
        ButterKnife.bind(this);
        if (getIntent().hasExtra("Weather")) {
            locationData = getIntent().getParcelableExtra("Weather");
            Log.e("sssss", new Gson().toJson(locationData));
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(locationData.getLocationName()).append("\n");
            for (int j = 0; j < locationData.getWeatherElement().size(); j++) {
                if (MINTFILTER.equals(locationData.getWeatherElement().get(j).getElementName())) {
                    for (int k = 0; k < locationData.getWeatherElement().get(j).getTime().size(); k++) {
                        stringBuffer.append(locationData.getWeatherElement().get(j).getTime().get(k).getStartTime()).append("\n");
                        stringBuffer.append(locationData.getWeatherElement().get(j).getTime().get(k).getStartTime()).append("\n");
                        stringBuffer.append(locationData.getWeatherElement().get(j).getTime().get(k).getParameter().getParameterName() +
                                locationData.getWeatherElement().get(j).getTime().get(k).getParameter().getParameterUnit()).append("\n");
                    }
                }
            }
            tvInfo.setText(stringBuffer.toString());
        }
    }
}
