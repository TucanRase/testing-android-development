package tucanrase.personal.project.models;

public class Forecastday {
    private String date;
    private Day day;



    public Forecastday(String date, Day day) {
        this.date = date;
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public Day getDay() {
        return day;
    }
}
