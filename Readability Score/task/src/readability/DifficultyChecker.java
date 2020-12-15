package readability;

public class DifficultyChecker {

    public Difficulty simpleCheck(String input) {
        if (input.length() <= 100)
            return Difficulty.EASY;

        return Difficulty.HARD;
    }
}
