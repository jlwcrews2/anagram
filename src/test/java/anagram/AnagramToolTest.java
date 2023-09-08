package anagram;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class AnagramToolTest {

    @Test
    void ShouldReturnNoMatches() {
        AnagramTool anagramTool = new AnagramTool();
        Map<String, ArrayList<String>> result = anagramTool.findAnagrams(Arrays.asList("word", "letter", "biscuit"));
        assert (result.get("letter").isEmpty());
    }

    @Test
    void shouldReturnPositiveResults() {
        AnagramTool anagramTool = new AnagramTool();
        Map<String, ArrayList<String>> result = anagramTool.findAnagrams(Arrays.asList("least", "slate", "steal", "tales", "team", "meat", "biscuit"));
        assert (result.get("steal").size() == 3);
    }
}
