import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class GameRoom implements Serializable {
    private List<Toy> toys = new ArrayList<>();
    private double balance;

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void sortToysByName() {
        toys.sort(Comparator.comparing(Toy::getName));
    }

    public void sortToysByType() {
        toys.sort(Comparator.comparing(Toy::getType));
    }

    public void sortToysByPrice() {
        toys.sort(Comparator.comparingDouble(Toy::getPrice));
    }
    public List<Toy> findToysByType(int toyType) {
        return toys.stream()
                .filter(toy -> toy.getType() == toyType)
                .collect(Collectors.toList());
    }

    public List<Toy> findToysByPriceRange(double minPrice, double maxPrice) {
        return toys.stream()
                .filter(toy -> toy.getPrice() >= minPrice && toy.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public void displayToys() {
        for (Toy toy : toys) {
            System.out.println(toy);
        }
    }

    public double getBalance() {
        return balance;
    }

    public void addFunds(double amount) {
        balance += amount;
        System.out.println("Баланс поповнено на " + amount + " грн. Поточний баланс: " + balance + " грн.");
    }

    public void buyToy(Toy toy) {
        if (balance >= toy.getPrice()) {
            addToy(toy);
            balance -= toy.getPrice();
            System.out.println("Товар придбано! Поточний баланс: " + balance + " грн.");
        } else {
            System.out.println("Недостатньо коштів для придбання товару.");
        }
    }
}
