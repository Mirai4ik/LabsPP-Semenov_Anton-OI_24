import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Market {
    private static final Random random = new Random();
    
    public static List<Toy> getAvailableToys() {
        return Arrays.asList(
                ToyFactory.createToy("Машинка", "Маленька", 20.0),
                ToyFactory.createToy("Лялька", "Середня", 30.0),
                ToyFactory.createToy("Робот", "Велика", 40.0),
                ToyFactory.createToy("Медвежа", "Середня", 25.0),
                ToyFactory.createToy("Пазл", "Маленька", 15.0),
                ToyFactory.createToy("Акційна Фігурка", "Середня", 35.0),
                ToyFactory.createToy("Настільна Гра", "Велика", 50.0),
                ToyFactory.createToy("Машинка з Дистанційним Керуванням", "Середня", 30.0),
                ToyFactory.createToy("Плюшевий Звір", "Маленька", 18.0),
                ToyFactory.createToy("Конструктор", "Велика", 45.0),
                ToyFactory.createToy("Йо-йо", "Маленька", 12.0),
                ToyFactory.createToy("Планер", "Велика", 28.0),
                ToyFactory.createToy("Іграшковий Поїзд", "Середня", 32.0),
                ToyFactory.createToy("Фігурка Динозавра", "Велика", 38.0),
                ToyFactory.createToy("Художній Набір", "Середня", 27.0),
                ToyFactory.createToy("Скакалка", "Маленька", 10.0),
                ToyFactory.createToy("Музичний Інструмент", "Середня", 40.0),
                ToyFactory.createToy("Ігрова Кухня", "Велика", 55.0),
                ToyFactory.createToy("Фрізбі", "Середня", 22.0),
                ToyFactory.createToy("М'яч", "Маленька", 17.0)
        );
    }
    public static Toy getRandomToy() {
        List<Toy> availableToys = getAvailableToys();
        int randomIndex = random.nextInt(availableToys.size());
        return availableToys.get(randomIndex);
    }
}
