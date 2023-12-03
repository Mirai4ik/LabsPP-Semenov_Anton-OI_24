import java.io.Serializable;

public class Toy implements Serializable {
    private String name;
    private int type;
    private double price;

    public Toy(String name, int type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public int getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String type = getTypeString();
        return "Name: " + name + ", Type: " + type + ", Price: " + price;
    }

    private String getTypeString() {
        switch (type) {
            case 1:
                return "Маленька";
            case 2:
                return "Середня";
            case 3:
                return "Велика";
            default:
                return "Невідомий тип";
        }
    }
}
