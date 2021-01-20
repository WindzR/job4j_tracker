package ru.job4j.tracker.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DiapasonFunc {

    public static List<Double> diapason(int start, int end, Function<Integer, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            result.add(func.apply(i));
        }
        return result;
    }
}
