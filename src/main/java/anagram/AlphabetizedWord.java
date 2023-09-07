package anagram;

public record AlphabetizedWord(String alphabetizedWord, String originalWord) implements Comparable<AlphabetizedWord> {

    @Override
    public int compareTo(AlphabetizedWord w) {
        return this.alphabetizedWord.compareTo(w.alphabetizedWord);
    }
}
