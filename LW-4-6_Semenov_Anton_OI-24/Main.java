import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.setProperty("console.encoding", "UTF-8");

        GameRoom gameRoom = new GameRoom();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenuOptions();

            System.out.print("Виберіть опцію: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Щоб зчитати залишок рядка після nextInt()

            switch (choice) {
                case 1:
                    addToyManually(scanner, gameRoom);
                    break;
                case 2:
                    buyToyAutomatically(gameRoom);
                    break;
                case 3:
                    gameRoom.displayToys();
                    break;
                case 4:
                    displaySortingMenu(scanner, gameRoom);
                    break;
                case 5:
                    displaySearchMenu(scanner, gameRoom);
                    break;
                case 6:
                    displayBalance(gameRoom);
                    break;
                case 7:
                    addFunds(scanner, gameRoom);
                    break;
                case 8:
                    System.out.println("Дякую за використання програми!");
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        } while (choice != 10);

        scanner.close(); // Закриваємо Scanner
    }

    private static void displayMenuOptions() {
        System.out.println("1. Додати іграшку(власноруч)");
        System.out.println("2. Купити іграшку(автоматично)");
        System.out.println("3. Вивести іграшки");
        System.out.println("4. Сортувати іграшки за типом");
        System.out.println("5. Пошук іграшок за параметром");
        System.out.println("6. Вивести баланс");
        System.out.println("7. Поповнити баланс");
        System.out.println("8. Вихід");
    }

    private static void displaySortingMenu(Scanner scanner, GameRoom gameRoom) {
        int sortingChoice;

        do {
            displaySortingOptions();

            System.out.print("Виберіть опцію сортування: ");
            sortingChoice = scanner.nextInt();
            scanner.nextLine(); // Щоб зчитати залишок рядка після nextInt()

            switch (sortingChoice) {
                case 1:
                    gameRoom.sortToysByName();
                    break;
                case 2:
                    gameRoom.sortToysByType();
                    break;
                case 3:
                    gameRoom.sortToysByPrice();
                    break;
                case 4:
                    System.out.println("Повертаємося до головного меню.");
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        } while (sortingChoice != 4);
    }

    private static void displaySortingOptions() {
        System.out.println("1. Сортувати за алфавітом");
        System.out.println("2. Сортувати за типом");
        System.out.println("3. Сортувати за ціною");
        System.out.println("4. Повернутися до головного меню");
    }

    private static void displaySearchMenu(Scanner scanner, GameRoom gameRoom) {
        int searchChoice;

        do {
            displaySearchOptions();

            System.out.print("Виберіть опцію пошуку: ");
            searchChoice = scanner.nextInt();
            scanner.nextLine(); // Щоб зчитати залишок рядка після nextInt()

            switch (searchChoice) {
                case 1:
                    searchToysByType(scanner, gameRoom);
                    break;
                case 2:
                    searchToysByPriceRange(scanner, gameRoom);
                    break;
                case 3:
                    System.out.println("Повертаємося до головного меню.");
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        } while (searchChoice != 3);
    }

    private static void displaySearchOptions() {
        System.out.println("1. Знайти за типом");
        System.out.println("2. Знайти за ціною(від і до)");
        System.out.println("3. Повернутися до головного меню");
    }

    private static void searchToysByType(Scanner scanner, GameRoom gameRoom) {
        System.out.print("Введіть тип іграшки (1 - Маленька, 2 - Середня, 3 - Велика): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        List<Toy> result = gameRoom.findToysByType(type);
        displaySearchResults(result);
    }

    private static void searchToysByPriceRange(Scanner scanner, GameRoom gameRoom) {
        System.out.print("Введіть мінімальну ціну: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Введіть максимальну ціну: ");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();

        List<Toy> result = gameRoom.findToysByPriceRange(minPrice, maxPrice);
        displaySearchResults(result);
    }

    private static void displaySearchResults(List<Toy> result) {
        if (result.isEmpty()) {
            System.out.println("Іграшок не знайдено за вказаними параметрами.");
        } else {
            System.out.println("Результати пошуку:");
            result.forEach(System.out::println);
        }
    }

    private static void addToyManually(Scanner scanner, GameRoom gameRoom) {
        System.out.print("Введіть назву іграшки: ");
        String name = scanner.nextLine();
        System.out.print("Введіть тип іграшки: ");
        int type = scanner.nextInt();
        System.out.print("Введіть ціну іграшки: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
    
        gameRoom.addToy(new Toy(name, type, price));
    }

    private static void buyToyAutomatically(GameRoom gameRoom) {
        gameRoom.buyToy(Market.getRandomToy());
    }

    private static void displayBalance(GameRoom gameRoom) {
        System.out.println("Баланс: " + gameRoom.getBalance() + " грн.");
    }

    private static void addFunds(Scanner scanner, GameRoom gameRoom) {
        System.out.print("Введіть суму для поповнення балансу: ");
        double amount = scanner.nextDouble();
        gameRoom.addFunds(amount);
    }
}
