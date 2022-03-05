package tucanrase.personal.project;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tucanrase.personal.project.models.WeatherData;

public interface WeatherApi {
    @GET("v1/current.json")
    Call<WeatherData> getWeather(
            @Query("key") String key,
            @Query("q") String q
    );
}
