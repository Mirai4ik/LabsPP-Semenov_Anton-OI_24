import java.util.ArrayList;
import java.util.List;

public class LucasSquares {
    public static void main(String[] args) {
        int n = 20;  // Задаємо кількість чисел Люка, які ми хочемо обчислити.

        List<Long> lucasNumbers = new ArrayList<>();  // Створюємо ArrayList для зберігання чисел Люка.
        lucasNumbers.add(1L);
        lucasNumbers.add(3L);

        for (int i = 2; i < n; i++) {
            // Обчислюємо наступне число Люка, додаючи два попередні числа Люка.
            long nextLucas = lucasNumbers.get(i - 1) + lucasNumbers.get(i - 2);
            lucasNumbers.add(nextLucas);
        }

        ArrayList<Long> lucasSquares = new ArrayList<>();  // Створюємо ArrayList для зберігання квадратів чисел Люка.
        for (long lucasNumber : lucasNumbers) {
            if (isPerfectSquare(lucasNumber)) {
                lucasSquares.add(lucasNumber);  // Додаємо число, яке є квадратом, до lucasSquares.
            }
        }

        System.out.println("First " + n + " Lucas numbers: " + lucasNumbers);  // Виводимо перші n чисел Люка.
        System.out.println("Squares among Lucas numbers: " + lucasSquares);  // Виводимо квадрати серед чисел Люка.
    }

    private static boolean isPerfectSquare(long number) {
        // Перевірка, чи число є квадратом іншого цілого числа.
        long squareRoot = (long) Math.sqrt(number);
        return squareRoot * squareRoot == number;
    }
}