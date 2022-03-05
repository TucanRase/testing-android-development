package tucanrase.personal.project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tucanrase.personal.project.models.WeatherData;

public class MainActivity extends AppCompatActivity {
    TextView tvLocation,tvLastUpdate,tvTemp,tvMinMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializer();

        fetchWeather();
    }

    void fetchWeather(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://api.weatherapi.com/").addConverterFactory(GsonConverterFactory.create()).build();
        WeatherApi weatherApi=retrofit.create(WeatherApi.class);
        Call<WeatherData> call=weatherApi.getWeather("13084a48383d4912bce114058220303","auto:ip");
        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                if(response.isSuccessful()){
                    WeatherData weatherData= response.body();
                    tvLocation.setText(weatherData.getLocation().getName());
                    tvLastUpdate.setText(weatherData.getCurrent().getLastUpdate());
                    tvTemp.setText(String.valueOf(weatherData.getCurrent().getTempC())+"ºC");

                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                System.out.println("Error: "+ t.getMessage());
            }
        });
    }

    public void initializer(){
        tvLocation=findViewById(R.id.tvLocation);
        tvLastUpdate=findViewById(R.id.tvLastUpdate);
        tvTemp=findViewById(R.id.tvTemp);
        tvMinMax=findViewById(R.id.tvMinMax);
    }
}