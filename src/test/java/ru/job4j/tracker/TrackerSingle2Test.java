package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSingle2Test {

    @Test
    public void getInstance() {
        Tracker tracker = TrackerSingle2.getInstance();
        Tracker tracker2 = TrackerSingle2.getInstance();
        assertSame(tracker, tracker2);
    }
}