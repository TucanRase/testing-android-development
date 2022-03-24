package tucanrase.personal.project.models;

public class Condition {
    private String text,icon;
    private int code;

    public Condition(String text, String icon, int code) {
        this.text = text;
        this.icon = icon;
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public String getIcon() {
        return icon;
    }

    public int getCode() {
        return code;
    }
}
