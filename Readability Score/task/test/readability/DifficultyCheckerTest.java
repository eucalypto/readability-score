package readability;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifficultyCheckerTest {

    DifficultyChecker checker;

    @BeforeEach
    void setup() {
        checker = new DifficultyChecker();
    }

    @Test
    void simpleCheckLessThan100Chars() {
        var simple = "This is simple to read!";

        var result = checker.simpleCheck(simple);

        assertEquals(Difficulty.EASY, result);
    }

    @Test
    void simpleCheckOver100Chars() {
        var hard = "This text is hard to read. It contains a lot of sentences as well as a lot of words in each sentence.";

        var result = checker.simpleCheck(hard);

        assertEquals(Difficulty.HARD, result);
    }

    @Test
    void simpleCheckExactly100Chars() {
        StringBuilder exact = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            exact.append("1234567890");
        }

        var result = checker.simpleCheck(exact.toString());

        assertEquals(Difficulty.EASY, result);
    }

}
