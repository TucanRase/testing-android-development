package tucanrase.personal.project.models;

import java.util.List;


public class Current {
    private String lastUpdate;
    private double tempC,tempF;
    Condition condition;

    public Current(String lastUpdate, double tempC, double tempF, Condition condition) {
        this.lastUpdate = lastUpdate;
        this.tempC = tempC;
        this.tempF = tempF;
        this.condition = condition;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
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

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
