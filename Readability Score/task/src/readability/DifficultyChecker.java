package readability;

import java.util.Arrays;

public class DifficultyChecker {

    public Difficulty simpleCheck(String input) {
        if (input.length() <= 100)
            return Difficulty.EASY;

        return Difficulty.HARD;
    }

    public Difficulty averageCheck(String text) {
        var sentenceTerminator = "[.!?]";

        var sentences = text.trim().split(sentenceTerminator);

        var wordCountAverage = Arrays.stream(sentences)
                .mapToInt(this::wordCount)
                .average()
                .orElseThrow();

        if (wordCountAverage <= 10.0)
            return Difficulty.EASY;
        else
            return Difficulty.HARD;
    }

    private int wordCount(String sentence) {
        return sentence.trim().split("\\s").length;
    }
}
