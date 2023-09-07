package anagram;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class AnagramTest {

    @Test
    void ShouldReturnNoMatches() {
        Anagram anagram = new Anagram();
        Map<String, ArrayList<String>> result = anagram.findAnagrams(Arrays.asList("word", "letter", "biscuit"));
        assert (result.get("letter").isEmpty());
    }

    @Test
    void shouldReturnPositiveResults() {
        Anagram anagram = new Anagram();
        Map<String, ArrayList<String>> result = anagram.findAnagrams(Arrays.asList("least", "slate", "steal", "tales", "team", "meat", "biscuit"));
        assert (result.get("steal").size() == 3);
    }
}
