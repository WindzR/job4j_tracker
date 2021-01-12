package ru.job4j.tracker;

public class TrackerSingle3 {
    private static Tracker instance = new Tracker();

    private TrackerSingle3() {
    }

    public static Tracker getInstance() {
        return instance;
    }
}
