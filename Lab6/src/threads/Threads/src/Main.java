
public class Main {
    public static void main(String[] args) {
        int numTerminals = 4; // Количество терминалов
        int numJetways = 3; // Количество трапов
        int[] destinations = {4, 5, 6}; // Пункты назначения
        int[] ranges = {2, 3}; // Зоны дальности

        Airport airport = new Airport(numTerminals, numJetways, destinations, ranges);
        airport.operate();
    }
}