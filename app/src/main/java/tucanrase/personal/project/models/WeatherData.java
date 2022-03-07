package tucanrase.personal.project.models;

import java.util.List;

public class WeatherData {
    private Current current;
    private Location location;
    private Forecast forecast;

    public WeatherData(Current current, Location location, Forecast forecast) {
        this.current = current;
        this.location = location;
        this.forecast = forecast;
    }

    public Current getCurrent() {
        return current;
    }

    public Location getLocation() {
        return location;
    }

    public Forecast getForecast() {
        return forecast;
    }
}
