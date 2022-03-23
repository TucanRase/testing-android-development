package tucanrase.personal.project.fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tucanrase.personal.project.R;
import tucanrase.personal.project.WeatherApi;
import tucanrase.personal.project.models.Forecastday;
import tucanrase.personal.project.models.WeatherData;

public class HomeFragment extends Fragment {

    private String location = "auto:ip";
    TextView tvLocation, tvLastUpdate, tvTemp, tvMinMax, dateTomorrow, dateAfterT, date2Days, minMax1, minMax2, minMax3;
    ImageView weatherIconNow, weatherIcon1, weatherIcon2, weatherIcon3;
    List<Forecastday> forecastDays = new ArrayList<>();
    CardView pbSearch;

    public HomeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            location = bundle.getString("location");
        }
        System.out.println(location);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        pbSearch = view.findViewById(R.id.loadingHome);
        tvLocation = view.findViewById(R.id.tvLocation);
        tvLastUpdate = view.findViewById(R.id.tvLastUpdate);
        tvTemp = view.findViewById(R.id.tvTemp);
        tvMinMax = view.findViewById(R.id.tvMinMax);

        dateTomorrow = view.findViewById(R.id.dateTomorrow);
        dateAfterT = view.findViewById(R.id.dateAfterT);
        date2Days = view.findViewById(R.id.date2Days);
        minMax1 = view.findViewById(R.id.minMax1);
        minMax2 = view.findViewById(R.id.minMax2);
        minMax3 = view.findViewById(R.id.minMax3);
        fetchWeather();
        return view;
    }

    void fetchWeather() {
        pbSearch.setVisibility(View.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.weatherapi.com/").addConverterFactory(GsonConverterFactory.create()).build();
        WeatherApi weatherApi = retrofit.create(WeatherApi.class);
        Call<WeatherData> call = weatherApi.getWeather("13084a48383d4912bce114058220303", location, "5", "15");
        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                if (response.isSuccessful()) {
                    WeatherData weatherData = response.body();
                    tvLocation.setText(weatherData.getLocation().getName());
                    tvLastUpdate.setText(weatherData.getCurrent().getLastUpdate());
                    tvTemp.setText(weatherData.getCurrent().getTempC() + "ºC");
                    forecastDays = weatherData.getForecast().getForecastDays();
                    tvTemp.setText(forecastDays.get(0).getDay().getMaxtemp_c() + "");
                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }
        });
        pbSearch.setVisibility(View.GONE);
    }
}