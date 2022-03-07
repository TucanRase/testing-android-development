package tucanrase.personal.project.models;

public class Day {
    private Double maxtemp_c, maxtemp_f, mintemp_c, mintemp_f, avgtemp_c, avgtemp_f, maxwind_mph, maxwind_kph, totalprecip_mm, totalprecip_in;
    private int daily_will_it_rain, daily_chance_of_rain, daily_will_it_snow, daily_chance_of_snow;
    private Condition condition;

    public Day(Double maxtemp_c, Double maxtemp_f, Double mintemp_c, Double mintemp_f, Double avgtemp_c, Double avgtemp_f, Double maxwind_mph, Double maxwind_kph, Double totalprecip_mm, Double totalprecip_in, int daily_will_it_rain, int daily_chance_of_rain, int daily_will_it_snow, int daily_chance_of_snow, Condition condition) {
        this.maxtemp_c = maxtemp_c;
        this.maxtemp_f = maxtemp_f;
        this.mintemp_c = mintemp_c;
        this.mintemp_f = mintemp_f;
        this.avgtemp_c = avgtemp_c;
        this.avgtemp_f = avgtemp_f;
        this.maxwind_mph = maxwind_mph;
        this.maxwind_kph = maxwind_kph;
        this.totalprecip_mm = totalprecip_mm;
        this.totalprecip_in = totalprecip_in;
        this.daily_will_it_rain = daily_will_it_rain;
        this.daily_chance_of_rain = daily_chance_of_rain;
        this.daily_will_it_snow = daily_will_it_snow;
        this.daily_chance_of_snow = daily_chance_of_snow;
        this.condition = condition;
    }

    public Double getMaxtemp_c() {
        return maxtemp_c;
    }

    public Double getMaxtemp_f() {
        return maxtemp_f;
    }

    public Double getMintemp_c() {
        return mintemp_c;
    }

    public Double getMintemp_f() {
        return mintemp_f;
    }

    public Double getAvgtemp_c() {
        return avgtemp_c;
    }

    public Double getAvgtemp_f() {
        return avgtemp_f;
    }

    public Double getMaxwind_mph() {
        return maxwind_mph;
    }

    public Double getMaxwind_kph() {
        return maxwind_kph;
    }

    public Double getTotalprecip_mm() {
        return totalprecip_mm;
    }

    public Double getTotalprecip_in() {
        return totalprecip_in;
    }

    public int getDaily_will_it_rain() {
        return daily_will_it_rain;
    }

    public int getDaily_chance_of_rain() {
        return daily_chance_of_rain;
    }

    public int getDaily_will_it_snow() {
        return daily_will_it_snow;
    }

    public int getDaily_chance_of_snow() {
        return daily_chance_of_snow;
    }

    public Condition getCondition() {
        return condition;
    }
}
