package readability;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Difficulty Checker")
class DifficultyCheckerTest {

    DifficultyChecker checker;

    @BeforeEach
    void setup() {
        checker = new DifficultyChecker();
    }

    @Nested
    @DisplayName("Simple Check")
    class SimpleCheck {

        @Nested
        @DisplayName("outputs HARD")
        class OutputsHard {

            @Test
            @DisplayName("at over 100 Characters")
            void over100Chars() {
                var hard = "This text is hard to read. It contains a lot of sentences as well as a lot of words in each sentence.";

                var result = checker.simpleCheck(hard);

                assertEquals(Difficulty.HARD, result);
            }
        }

        @Nested
        @DisplayName("outputs EASY")
        class OutputsEasy {

            @Test
            @DisplayName("below 100 Characters")
            void lessThan100Chars() {
                var simple = "This is simple to read!";

                var result = checker.simpleCheck(simple);

                assertEquals(Difficulty.EASY, result);
            }

            @Test
            @DisplayName("at exactly 100 Characters")
            void exactly100Chars() {
                var oneHundredCharacters = "1234567890".repeat(10);
                var result = checker.simpleCheck(oneHundredCharacters);

                assertEquals(Difficulty.EASY, result);
            }

        }


    }

}
