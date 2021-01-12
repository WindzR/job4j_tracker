package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSingle3Test {

    @Test
    public void getInstance() {
        Tracker tracker = TrackerSingle3.getInstance();
        Tracker tracker2 = TrackerSingle3.getInstance();
        assertSame(tracker, tracker2);
    }
}