package tucanrase.personal.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tucanrase.personal.project.models.Forecastday;
import tucanrase.personal.project.models.Search;
import tucanrase.personal.project.models.WeatherData;

public class MainActivity extends AppCompatActivity {
    TextView tvLocation, tvLastUpdate, tvTemp, tvMinMax, dateTomorrow, dateAfterT, date2Days, minMax1, minMax2, minMax3;
    ImageView weatherIconNow, weatherIcon1, weatherIcon2, weatherIcon3;
    List<Forecastday> forecastDays = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializer();

        fetchWeather();

        startActivity(new Intent(getApplicationContext(), ActivityTest.class));
    }

    void fetchWeather() {
        // TODO: 07/03/2022 add loading bar
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.weatherapi.com/").addConverterFactory(GsonConverterFactory.create()).build();
        WeatherApi weatherApi = retrofit.create(WeatherApi.class);
        Call<WeatherData> call = weatherApi.getWeather("13084a48383d4912bce114058220303", "telde", "5", "15");
        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                if (response.isSuccessful()) {
                    WeatherData weatherData = response.body();
                    tvLocation.setText(weatherData.getLocation().getName());
                    tvLastUpdate.setText(weatherData.getCurrent().getLastUpdate());
                    tvTemp.setText(weatherData.getCurrent().getTempC() + "ºC");
                    forecastDays = weatherData.getForecast().getForecastDays();
                    System.out.println(forecastDays.get(0).getDay().getMaxtemp_c() + "");
                    tvTemp.setText(forecastDays.get(0).getDay().getMaxtemp_c() + "");
                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }
        });
    }

    void fetchSearch() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.weatherapi.com/").addConverterFactory(GsonConverterFactory.create()).build();
        WeatherApi weatherApi = retrofit.create(WeatherApi.class);
        Call<List<Search>> call = weatherApi.getSearch("auto:ip");
        call.enqueue(new Callback<List<Search>>() {
            @Override
            public void onResponse(Call<List<Search>> call, Response<List<Search>> response) {
                if (response.isSuccessful()) {
                    List<Search> searchData = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<Search>> call, Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }
        });
    }

    public void initializer() {
        tvLocation = findViewById(R.id.tvLocation);
        tvLastUpdate = findViewById(R.id.tvLastUpdate);
        tvTemp = findViewById(R.id.tvTemp);
        tvMinMax = findViewById(R.id.tvMinMax);

        dateTomorrow = findViewById(R.id.dateTomorrow);
        dateAfterT = findViewById(R.id.dateAfterT);
        date2Days = findViewById(R.id.date2Days);
        minMax1 = findViewById(R.id.minMax1);
        minMax2 = findViewById(R.id.minMax2);
        minMax3 = findViewById(R.id.minMax3);
    }
}