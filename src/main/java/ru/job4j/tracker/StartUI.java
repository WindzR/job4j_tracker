package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
       Item item = new Item(1, "John");
       Tracker track = new Tracker();
       track.add(item);
       System.out.println(track.findById(1));
    }
}
