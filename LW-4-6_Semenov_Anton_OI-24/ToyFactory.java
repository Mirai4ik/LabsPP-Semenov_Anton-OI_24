public class ToyFactory {
    public static Toy createToy(String name, String type, double price) {
        int size;
        switch (type.toLowerCase()) {
            case "маленька":
                size = 1;
                break;
            case "середня":
                size = 2;
                break;
            case "велика":
                size = 3;
                break;
            default:
                size = 0;
        }
        return new Toy(name, size, price);
    }
}
