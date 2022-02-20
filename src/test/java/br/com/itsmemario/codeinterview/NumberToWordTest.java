package br.com.itsmemario.codeinterview;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberToWordTest {

    NumberToWord numberToWord = new NumberToWord();

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/numberToWord.csv"})
    void parameterizedTest(int number, String word) {
        assertThat(numberToWord.convertToWord(number)).isEqualToIgnoringCase(word);
    }
}