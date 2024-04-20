import java.util.Random;

public class RandomLetter {
    public static void main(String[] args) {
        int count = 5; // Заданное количество случайных чисел
        Random random = new Random();

        // С переходом на новую строку
        for (int i = 0; i < count; i++) {
            System.out.println(random.nextInt());
        }

        System.out.println(); // Пустая строка

        // Без перехода на новую строку
        for (int i = 0; i < count; i++) {
            System.out.print(random.nextInt() + " ");
        }
    }
}