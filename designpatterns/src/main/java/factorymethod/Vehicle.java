package factorymethod;

public class Vehicle {
    private String type;    // 운송 수단 종류
    private String color;   // 색상

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
