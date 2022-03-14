package tucanrase.personal.project;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tucanrase.personal.project.models.Search;
import tucanrase.personal.project.models.WeatherData;

public interface WeatherApi {
    @GET("v1/forecast.json")
    Call<WeatherData> getWeather(
            @Query("key") String key,
            @Query("q") String q,
            @Query("days") String days,
            @Query("hour") String hour
    );

    @GET("v1/search.json")
    Call<List<Search>> getSearch(
            @Query("q") String q
    );
}
