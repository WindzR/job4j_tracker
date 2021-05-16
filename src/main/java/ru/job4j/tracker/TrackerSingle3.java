package ru.job4j.tracker;

public class TrackerSingle3 {
    private static MemTracker instance = new MemTracker();

    private TrackerSingle3() {
    }

    public static MemTracker getInstance() {
        return instance;
    }
}
