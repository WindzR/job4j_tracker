package ru.job4j.tracker.lambda;

import java.util.Comparator;

public class LambdaBlock {
    public static void main(String[] args) {
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("Сравнение - " + left + " : " + right);
            return right.compareTo(left);
        };
    }
}
