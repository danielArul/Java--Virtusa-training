package lk.codelabs.encap;

public class Bus {

    private String model;
    private String color;

    public Bus( String color) {

        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
