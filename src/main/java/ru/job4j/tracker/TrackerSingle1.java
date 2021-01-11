package ru.job4j.tracker;

public enum TrackerSingle1 {
    INSTANCE;

    private Tracker tracker = new Tracker();

    public Tracker getInstance() {
        return tracker;
    }
}
