package tucanrase.personal.project.models;

import java.util.List;

public class Forecast {
    private List<Forecastday> forecastday;

    public Forecast(List<Forecastday> forecastday) {
        this.forecastday = forecastday;
    }

    public List<Forecastday> getForecastDays() {
        return forecastday;
    }
}
