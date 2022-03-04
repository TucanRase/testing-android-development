package tucanrase.personal.project;

public class WeatherData {
    private String location,country,timeZone,localtime,lastUpdate,weather;
    private int code,isDay,clouds;
    private double tempC,tempF;

    public WeatherData(String location, String country, String timeZone, String localtime, String lastUpdate, String weather, int code, int isDay, int clouds, double tempC, double tempF) {
        this.location = location;
        this.country = country;
        this.timeZone = timeZone;
        this.localtime = localtime;
        this.lastUpdate = lastUpdate;
        this.weather = weather;
        this.code = code;
        this.isDay = isDay;
        this.clouds = clouds;
        this.tempC = tempC;
        this.tempF = tempF;
    }

    public WeatherData(){}

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getIsDay() {
        return isDay;
    }

    public void setIsDay(int isDay) {
        this.isDay = isDay;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public double getTempC() {
        return tempC;
    }

    public void setTempC(double tempC) {
        this.tempC = tempC;
    }

    public double getTempF() {
        return tempF;
    }

    public void setTempF(double tempF) {
        this.tempF = tempF;
    }
}
