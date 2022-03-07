package tucanrase.personal.project.models;

public class Location {
    private String name, region, country, tz_id, localtime;
    private double lat, lon;

    public Location(String name, String region, String country, String timezone, String localtime, double lat, double lon) {
        this.name = name;
        this.region = region;
        this.country = country;
        this.tz_id = timezone;
        this.localtime = localtime;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getTz_id() {
        return tz_id;
    }

    public String getLocaltime() {
        return localtime;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
