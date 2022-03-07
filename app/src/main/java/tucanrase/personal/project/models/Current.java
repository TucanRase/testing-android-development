package tucanrase.personal.project.models;

public class Current {
    private String last_updated;
    private float temp_c,temp_f;
    private int is_day;
    Condition condition;

    public Current(String last_updated, float temp_c, float temp_f, int is_day, Condition condition) {
        this.last_updated = last_updated;
        this.temp_c = temp_c;
        this.temp_f = temp_f;
        this.is_day = is_day;
        this.condition = condition;
    }

    public String getLastUpdate() {
        return last_updated;
    }

    public void setLastUpdate(String lastUpdate) {
        this.last_updated = lastUpdate;
    }

    public float getTempC() {
        return temp_c;
    }

    public void setTempC(float tempC) {
        this.temp_c = tempC;
    }

    public float getTempF() {
        return temp_f;
    }

    public void setTempF(float tempF) {
        this.temp_f = tempF;
    }

    public int getIs_day() {
        return is_day;
    }

    public void setIs_day(int is_day) {
        this.is_day = is_day;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
