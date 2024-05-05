public class SumLetter {
    public static void main(String[] args) {
        int sum = 0;
        int product = 1;

        for (String arg : args) {
            int number = Integer.parseInt(arg);
            sum += number;
            product *= number;
        }

        System.out.println("Сумма: " + sum);
        System.out.println("Произведение: " + product);
    }
}