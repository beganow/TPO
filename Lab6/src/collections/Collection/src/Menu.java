import java.util.Scanner;
import java.util.List;
public class Menu {
    private Disc disc;
    public Menu(Disc disc) {
        this.disc = disc;
    }

    public void display() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("Меню:");
            System.out.println("1. Подсчитать продолжительность диска");
            System.out.println("2. Перестановка композиций по стилю");
            System.out.println("3. Поиск композиции по диапазону длины треков");
            System.out.println("0. Выйти из программы");
            System.out.print("Введите номер выбранного пункта: ");

            choice = sc.nextInt();
            int minLength, maxLength;
            switch(choice) {
                case 1:
                    int totalDuration = disc.getDuration();
                    System.out.println("Продолжительность диска: " + totalDuration + " секунд");
                    break;
                case 2:
                    System.out.print("Введите стиль, по которому хотите отсортировать композиции: ");
                    String style = sc.next();
                    disc.StyleChange(style);
                    System.out.println("Композиции переставлены по стилю: " + style);
                    // После того как композиции переставлены, можно вывести список композиций на экран
                    System.out.println("Список композиций после перестановки:");
                    for (Song song : disc.getSongs()) {
                        System.out.println(song.getTitle() + " - " + song.getStyle());
                    }
                    break;
                case 3:
                    System.out.print("Введите минимальную длину трека (в секундах): ");
                    minLength = sc.nextInt();
                    System.out.print("Введите максимальную длину трека (в секундах): ");
                    maxLength = sc.nextInt();
                    List<Song> songsInRange = disc.searchForLenght(minLength, maxLength);
                    System.out.println("Композиции в заданном диапазоне длины треков:");
                    for (Song song : songsInRange) {
                        System.out.println(song.getTitle() + " - " + song.getDuration() + " секунд");
                    }
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите существующий пункт меню.");
            }
        }
        while (choice != 0);
        sc.close();
    }
}
