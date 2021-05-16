package ru.job4j.tracker.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaBlock {
    public static void main(String[] args) {
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("Сравнение - " + left + " : " + right);
            return right.compareTo(left);
        };
        String[] names = {
                "Ivan",
                "Petr"
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return left.length() - right.length();
        };
        Arrays.sort(names, lengthCmp);
    }
}
