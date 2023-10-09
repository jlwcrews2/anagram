package anagram;

import java.util.*;

public class AnagramTool {

    Map<String, ArrayList<String>> findAnagrams(List<String> wordList) {
        Map<String, ArrayList<String>> results = new HashMap<>();
        List<AlphabetizedWord> alphabetizedWordList = createAlphabetizedWordList(wordList);

        alphabetizedWordList.forEach(word -> results.put(word.originalWord(), new ArrayList<>()));

        for (AlphabetizedWord word : alphabetizedWordList) {
            alphabetizedWordList.stream()
                    .filter(w -> w.alphabetizedWord().equals(word.alphabetizedWord()))
                    .filter(w -> !w.originalWord().equals(word.originalWord()))
                    .forEach(w -> {
                        ArrayList<String> anagramList = results.get(word.originalWord());
                        anagramList.add(w.originalWord());
                        results.put(word.originalWord(), anagramList);
                    });
        }

        results.forEach((key, value) -> System.out.printf("key: %s, value: %s%n", key, value));

        return results;
    }

    List<AlphabetizedWord> createAlphabetizedWordList(List<String> wordList) {
        return wordList.stream().map(word -> {
            char[] alphaWord = word.toCharArray();
            Arrays.sort(alphaWord);
            String sortedWord = new String(alphaWord);
            return new AlphabetizedWord(sortedWord, word);
        }).sorted().toList();
    }
}

