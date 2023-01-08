package ch1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Objects;

import static org.assertj.core.api.Assertions.*;

public class CalcSumTest {

    Calculator calculator;
    String numFilePath;

    @BeforeEach
    public void setup(){
        this.calculator = new Calculator();
        this.numFilePath = "/Users/ijunhyeong/Desktop/numbers.txt";
    }

    @Test
    public void sumOfNumbers() throws IOException {
        assertThat(calculator.calcSum(numFilePath)).isEqualTo(10);
    }
    @Test
    public void multiplyOfNumbers() throws IOException {
        assertThat(calculator.calcMultiply(numFilePath)).isEqualTo(24);
    }
    @Test
    public void concatenateStrings() throws IOException {
        assertThat(calculator.concatenate(numFilePath)).isEqualTo("1234");
    }
}
