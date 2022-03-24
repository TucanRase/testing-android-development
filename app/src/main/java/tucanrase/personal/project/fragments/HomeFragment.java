package tucanrase.personal.project.fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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
    TextView tvLocation, tvLastUpdate, tvTemp, tvMinMax, dateAfterT, date2Days, minMax1, minMax2, minMax3;
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
        dateAfterT = view.findViewById(R.id.dateAfterT);
        date2Days = view.findViewById(R.id.date2Days);
        weatherIconNow = view.findViewById(R.id.weatherIconNow);
        weatherIcon1 = view.findViewById(R.id.weatherIcon1);
        weatherIcon2 = view.findViewById(R.id.weatherIcon2);
        weatherIcon3 = view.findViewById(R.id.weatherIcon3);
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
                    Picasso.get().load("https:"+weatherData.getCurrent().getCondition().getIcon()).fit().into(weatherIconNow);
                    tvLocation.setText(weatherData.getLocation().getName());
                    tvLastUpdate.setText(weatherData.getCurrent().getLastUpdate());
                    tvTemp.setText(weatherData.getCurrent().getTempC() + "º");
                    forecastDays = weatherData.getForecast().getForecastDays();
                    tvMinMax.setText(forecastDays.get(0).getDay().getMintemp_c() + "º/"+forecastDays.get(0).getDay().getMaxtemp_c()+"º");
                    Picasso.get().load("https:"+forecastDays.get(0).getDay().getCondition().getIcon()).fit().into(weatherIcon1);
                    Picasso.get().load("https:"+forecastDays.get(1).getDay().getCondition().getIcon()).fit().into(weatherIcon2);
                    Picasso.get().load("https:"+forecastDays.get(2).getDay().getCondition().getIcon()).fit().into(weatherIcon3);
                    dateAfterT.setText(forecastDays.get(1).getDate());
                    date2Days.setText(forecastDays.get(2).getDate());
                    minMax1.setText(forecastDays.get(0).getDay().getMintemp_c()+"º/"+forecastDays.get(0).getDay().getMaxtemp_c()+"º");
                    minMax2.setText(forecastDays.get(1).getDay().getMintemp_c()+"º/"+forecastDays.get(0).getDay().getMaxtemp_c()+"º");
                    minMax3.setText(forecastDays.get(2).getDay().getMintemp_c()+"º/"+forecastDays.get(0).getDay().getMaxtemp_c()+"º");

                    System.out.println(forecastDays.get(2).getDay().getCondition().getIcon());

                    pbSearch.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                System.out.println("Error: " + t.getMessage());
                pbSearch.setVisibility(View.GONE);
            }
        });
    }
}