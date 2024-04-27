import java.util.*;

public class TextAn {
    private String text;

    public TextAn(String text) {
        this.text = text;
    }

    public void findSentencesWithSameWords() {
        String[] sentences = text.split("[.!?]\\s*"); // Разделение текста на предложения
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String sentence : sentences) {
            String[] words = sentence.split("\\W+"); // Разделение предложения на слова

            for (String word : words) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        int maxCount = Collections.max(wordCountMap.values());

        List<String> sentencesWithSameWords = new ArrayList<>();
        for (String sentence : sentences) {
            String[] words = sentence.split("\\W+");

            for (String word : words) {
                if (wordCountMap.get(word) == maxCount) {
                    sentencesWithSameWords.add(sentence);
                    break;
                }
            }
        }

        System.out.println("Предложения с одинаковыми словами:");
        for (String sentence : sentencesWithSameWords) {
            System.out.println(sentence);
        }
    }

    public void sortSentencesByWordCount() {
        String[] sentences = text.split("[.!?]\\s*");

        List<String> sortedSentences = new ArrayList<>(Arrays.asList(sentences));
        sortedSentences.sort(Comparator.comparingInt(s -> s.split("\\W+").length));

        System.out.println("Предложения в порядке возрастания количества слов:");
        for (String sentence : sortedSentences) {
            System.out.println(sentence);
        }
    }

    public void findUniqueWordInFirstSentence() {
        String[] sentences = text.split("[.!?]\\s*");
        String firstSentence = sentences[0];
        String[] firstSentenceWords = firstSentence.split("\\W+");

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(firstSentenceWords));

        for (int i = 1; i < sentences.length; i++) {
            String[] words = sentences[i].split("\\W+");

            for (String word : words) {
                uniqueWords.remove(word);
            }
        }

        System.out.println("Слово в первом предложении, которого нет в остальных предложениях:");
        if (!uniqueWords.isEmpty()) {
            System.out.println(uniqueWords.iterator().next());
        } else {
            System.out.println("Такого слова не найдено.");
        }
    }

    public void findWordsInQuestionSentences(int wordLength) {
        String[] sentences = text.split("[.!?]\\s*");

        Set<String> uniqueWords = new HashSet<>();

        for (String sentence : sentences) {
            if (sentence.endsWith("?")) {
                String[] words = sentence.split("\\W+");

                for (String word : words) {
                    if (word.length() == wordLength) {
                        uniqueWords.add(word);
                    }
                }
            }
        }

        System.out.println("Слова заданной длины во всех вопросительных предложениях:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }
    }

    public void swapFirstAndLastWordInSentences() {
        String[] sentences = text.split("[.!?]\\s*");

        StringBuilder result = new StringBuilder();

        for (String sentence : sentences) {
            String[] words = sentence.split("\\W+");
            if (words.length > 1) {
                String firstWord = words[0];
                words[0] = words[words.length - 1];
                words[words.length - 1] = firstWord;
            }

            for (String word : words) {
                result.append(word).append(" ");
            }
            result.append(sentence.charAt(sentence.length() - 1)).append(" ");
        }

        System.out.println("Текст с поменянными первыми и последними словами:");
        System.out.println(result.toString().trim());
    }
}