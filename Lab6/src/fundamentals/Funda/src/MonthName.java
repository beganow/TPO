import java.util.Scanner;

public class MonthName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число от 1 до 12: ");
        int monthNumber = scanner.nextInt();

        if (monthNumber >= 1 && monthNumber <= 12) {
            String monthName = getMonthName(monthNumber);
            System.out.println("Название месяца: " + monthName);
        } else {
            System.out.println("Введено некорректное число месяца.");
        }
    }

    private static String getMonthName(int monthNumber) {
        switch (monthNumber) {
            case 1:
                return "Январь";
            case 2:
                return "Февраль";
            case 3:
                return "Март";
            case 4:
                return "Апрель";
            case 5:
                return "Май";
            case 6:
                return "Июнь";
            case 7:
                return "Июль";
            case 8:
                return "Август";
            case 9:
                return "Сентябрь";
            case 10:
                return "Октябрь";
            case 11:
                return "Ноябрь";
            case 12:
                return "Декабрь";
            default:
                return "";
        }
    }
}