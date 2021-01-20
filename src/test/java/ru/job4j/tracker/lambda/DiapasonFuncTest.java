package ru.job4j.tracker.lambda;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DiapasonFuncTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = DiapasonFunc.diapason(5, 8, x -> (double) 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenSquareResults() {
        List<Double> result = DiapasonFunc.diapason(2, 6, x -> Math.pow(x, 2) + 5);
        List<Double> expected = Arrays.asList(9D, 14D, 21D, 30D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenExponentialResults() {
        List<Double> result = DiapasonFunc.diapason(2, 5, x -> Math.pow(2, x) + 2);
        List<Double> expected = Arrays.asList(6D, 10D, 18D);
        assertThat(result, is(expected));
    }
}