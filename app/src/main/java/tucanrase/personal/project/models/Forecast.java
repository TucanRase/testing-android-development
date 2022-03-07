package tucanrase.personal.project.models;

import java.util.List;

public class Forecast {
    private List<ForecastDay> forecastDays;

    public Forecast(List<ForecastDay> forecastDays) {
        this.forecastDays = forecastDays;
    }

    public List<ForecastDay> getForecastDays() {
        return forecastDays;
    }
}
