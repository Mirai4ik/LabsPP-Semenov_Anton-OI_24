import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

class Droid {
    protected String name;
    protected int health;
    protected int damage;

    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return "Droid{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                '}';
    }
}

class Tank extends Droid {
    public Tank(String name) {
        super(name, 150, 20);
    }
}

class Assault extends Droid {
    public Assault(String name) {
        super(name, 100, 30);
    }
}

public class BattleDroidsGame {
    private static Random random = new Random();
    private static List<Droid> droids = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCommands:");
            System.out.println("1 - Create a Tank droid");
            System.out.println("2 - Create an Assault droid");
            System.out.println("3 - Show the list of created droids");
            System.out.println("4 - Start a 1-on-1 duel");
            System.out.println("5 - Exit the program");
            System.out.print("Enter the command number: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the input buffer

            switch (choice) {
                case 1:
                    createDroid(Tank.class);
                    break;
                case 2:
                    createDroid(Assault.class);
                    break;
                case 3:
                    showDroids();
                    break;
                case 4:
                    startDuel();
                    break;
                case 5:
                    System.out.println("Game over.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void createDroid(Class<? extends Droid> droidType) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the droid's name: ");
        String name = scanner.nextLine();

        Droid droid = null;

        try {
            droid = droidType.getConstructor(String.class).newInstance(name);
        } catch (Exception e) {
            System.out.println("Error creating the droid.");
        }

        if (droid != null) {
            droids.add(droid);
            System.out.println("Droid " + droid.getName() + " created!");
        }
    }

    private static void showDroids() {
        if (droids.isEmpty()) {
            System.out.println("\nThe list of droids is empty.");
        } else {
            System.out.println("\nList of droids:");
            for (int i = 0; i < droids.size(); i++) {
                Droid droid = droids.get(i);
                System.out.println(i + ": " + droid.getName() + "");
            }
        }
    }

    private static void startDuel() {
        if (droids.size() < 2) {
            System.out.println("You need at least two droids to start a duel.");
            return;
        }

        System.out.println("Choose droids for the duel:");

        showDroids();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Select the first droid (enter index): ");
        int index1 = scanner.nextInt();

        System.out.print("Select the second droid (enter index): ");
        int index2 = scanner.nextInt();

        if (index1 < 0 || index1 >= droids.size() || index2 < 0 || index2 >= droids.size()) {
            System.out.println("Invalid droid index.");
            return;
        }

        Droid droid1 = droids.get(index1);
        Droid droid2 = droids.get(index2);

        System.out.println("The duel begins!");
        duel(droid1, droid2);
    }

    private static void writeDuelResultToFile(Droid droid1, Droid droid2) {
        try {
            FileWriter writer = new FileWriter("duel_results.txt", true);
            writer.write(droid1.getName() + " vs " + droid2.getName() + "\n");

            if (droid1.isAlive()) {
                writer.write(droid1.getName() + " wins!\n");
            } else {
                writer.write(droid2.getName() + " wins!\n");
            }

            writer.write("\n");
            writer.close();
            System.out.println("Duel result has been written to the duel_results.txt file.");
        } catch (IOException e) {
            System.out.println("Error writing duel results to the file.");
        }
    }

    private static void duel(Droid droid1, Droid droid2) {
        while (droid1.isAlive() && droid2.isAlive()) {
            int damage1 = random.nextInt(droid1.getDamage());
            int damage2 = random.nextInt(droid2.getDamage());

            droid1.takeDamage(damage2);
            droid2.takeDamage(damage1);

            System.out.println(droid1.getName() + " attacks " + droid2.getName() + " and deals " + damage1 + " damage.");
            System.out.println(droid2.getName() + " attacks " + droid1.getName() + " and deals " + damage2 + " damage.");
        }

        if (droid1.isAlive()) {
            System.out.println("\n" + droid1.getName() + " wins!");
        } else {
            System.out.println("\n" + droid2.getName() + " wins!");
        }
        writeDuelResultToFile(droid1, droid2);
    }
}
