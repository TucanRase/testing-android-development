package tucanrase.personal.project.models;

public class WeatherData {
    private Current current;
    private Location location;

    public WeatherData(Current current, Location location) {
        this.current = current;
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
