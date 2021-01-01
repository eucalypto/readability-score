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

    @Nested
    @DisplayName("Average Word Count")
    class AverageWordCount {

        @Nested
        @DisplayName("outputs EASY")
        class OutputsEasy {

            @Test
            @DisplayName("for one sentence with less than 10 words")
            void oneSentence_lessThan10Words() {
                var sentence = "This text is simple to read!";

                var result = checker.averageCheck(sentence);

                assertEquals(Difficulty.EASY, result);
            }

            @Test
            @DisplayName("for one sentence with exactly 10 words")
            void oneSentence_exactly10Words() {
                var sentence = "This text is simple to read and to read aloud!";

                var result = checker.averageCheck(sentence);

                assertEquals(Difficulty.EASY, result);
            }

            @Test
            @DisplayName("for one sentence with exactly 10 words and beginning and ending whitespace")
            void oneSentence_exactly10WordsWithWhitespace() {
                var sentence = " This text is simple to read and to read aloud! ";

                var result = checker.averageCheck(sentence);

                assertEquals(Difficulty.EASY, result);
            }

            @Test
            @DisplayName("for one sentence with exactly 10 words of numbers")
            void oneSentence_exactly10WordsOfNumbers() {
                var sentence = "75 12, 241 123, 123 123 123, 123 123 123?";

                var result = checker.averageCheck(sentence);

                assertEquals(Difficulty.EASY, result);
            }


            @Test
            @DisplayName("for two sentences with less than 10 words each")
            void twoSentences_lessThan10Words() {
                var sentence = "This text is simple to read! It has on average less than 10 words per sentence.";

                var result = checker.averageCheck(sentence);

                assertEquals(Difficulty.EASY, result);
            }


            @Test
            @DisplayName("for three sentences with exactly 10 words each consisting of numbers")
            void threeSentences_lessThan10WordsInNumbers() {
                var sentence = "12, 12 13 14 14 14, 12 21 23 89! 75 12, 241 123, 123 123 123, 123 123 123? 123, 123 123 123 23 123 213 123 123 123.";

                var result = checker.averageCheck(sentence);

                assertEquals(Difficulty.EASY, result);
            }


        }

        @Nested
        @DisplayName("outputs HARD")
        class OutputsHard {

            @Test
            @DisplayName("for one sentence with more than 10 words")
            void oneSentence_moreThan10Words() {
                var sentence = "This sentence is long and thus contains a lot of words and phrases";

                var result = checker.averageCheck(sentence);

                assertEquals(Difficulty.HARD, result);
            }

            @Test
            @DisplayName("for two sentences with more than 10 words each")
            void twoSentences_moreThan10WordsEach() {
                var sentence = "This sentence is long and thus contains a lot of words and phrases? It contains a lot of sentences as well as a lot of words in each sentence";

                var result = checker.averageCheck(sentence);

                assertEquals(Difficulty.HARD, result);
            }


            @Test
            @DisplayName("for two sentences with more than 10 words on average")
            void twoSentences_moreThan10WordsOnAverage() {
                var sentence = "This text is hard to read. It contains a lot of sentences as well as a lot of words in each sentence";

                var result = checker.averageCheck(sentence);

                assertEquals(Difficulty.HARD, result);
            }


        }


    }

}
