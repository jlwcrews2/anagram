package anagram;

import java.util.*;

public class AnagramTool {

    Map<String, ArrayList<String>> findAnagrams(List<String> wordList) {
        Map<String, ArrayList<String>> result = new HashMap<>();
        List<AlphabetizedWord> alphabetizedWordList = createAlphabetizedWordList(wordList);

        alphabetizedWordList.forEach(word -> result.put(word.originalWord(), new ArrayList<>()));

        for (AlphabetizedWord word : alphabetizedWordList) {
            alphabetizedWordList.stream()
                    .filter(w -> w.alphabetizedWord().equals(word.alphabetizedWord()))
                    .filter(w -> !w.originalWord().equals(word.originalWord()))
                    .forEach(w -> {
                        ArrayList<String> anagramList = result.get(word.originalWord());
                        anagramList.add(w.originalWord());
                        result.put(word.originalWord(), anagramList);
                    });
        }

        result.forEach((key, value) -> System.out.printf("key: %s, value: %s%n", key, value));

        return result;
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

