package ru.job4j.tracker;

public class TrackerSingle2 {
    private static TrackerSingle2 instance;
    private Tracker tracker = new Tracker();

    private TrackerSingle2() {
    }

    public static TrackerSingle2 getInstance() {
        if (instance == null) {
            instance = new TrackerSingle2();
        }
        return instance;
    }

    public Tracker getTracker() {
        return tracker;
    }

    @Override
    public String toString() {
        return "" + tracker + "";
    }
}
