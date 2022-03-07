package tucanrase.personal.project.models;

public class Condition {
    private String text;
    private int code;

    public Condition(String text, int code) {
        this.text = text;
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public int getCode() {
        return code;
    }
}
