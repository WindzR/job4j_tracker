package ru.job4j.tracker;

public class TrackerSingle2 {
    private static TrackerSingle2 instance;
    private final Tracker tracker;

    private TrackerSingle2(Tracker tracker) {
        this.tracker = tracker;
    }

    public static TrackerSingle2 getInstance() {
        Tracker tracker = new Tracker();
        if (instance == null) {
            instance = new TrackerSingle2(tracker);
        }
        return instance;
    }

    @Override
    public String toString() {
        return "" + tracker + "";
    }
}
