package tucanrase.personal.project.models;

public class Search {
    int id;
    double lat,lon;
    String name,region,country,url;

    public Search(int id, double lat, double lon, String name, String region, String country, String url) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.region = region;
        this.country = country;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
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

    public String getUrl() {
        return url;
    }
}
