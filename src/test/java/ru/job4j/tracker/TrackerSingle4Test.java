package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSingle4Test {

    @Test
    public void getInstance() {
        Tracker tracker = TrackerSingle4.getInstance();
        Tracker tracker2 = TrackerSingle4.getInstance();
        assertSame(tracker, tracker2);
    }
}