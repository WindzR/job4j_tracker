package ru.job4j.tracker;

public class TrackerSingle4 {
    private final Tracker tracker = new Tracker();

    private TrackerSingle4() {
    }

    public static TrackerSingle4 getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingle4 INSTANCE = new TrackerSingle4();
    }

    public Tracker getTracker() {
        return tracker;
    }
}
