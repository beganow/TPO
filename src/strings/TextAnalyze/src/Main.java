import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String text = readFile("text.txt");

            TextAn analyzer = new TextAn(text);

            analyzer.findSentencesWithSameWords();
            System.out.println();

            analyzer.sortSentencesByWordCount();
            System.out.println();

            analyzer.findUniqueWordInFirstSentence();
            System.out.println();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите длину слова для поиска в вопросительных предложениях: ");
            int wordLength = scanner.nextInt();
            analyzer.findWordsInQuestionSentences(wordLength);
            System.out.println();

            analyzer.swapFirstAndLastWordInSentences();
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    private static String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}