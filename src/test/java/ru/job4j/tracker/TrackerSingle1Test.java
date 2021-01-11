package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSingle1Test {

    @Test
    public void getInstance() {
        TrackerSingle1 tracker = TrackerSingle1.INSTANCE;
        TrackerSingle1 tracker2 = TrackerSingle1.INSTANCE;
        assertSame(tracker, tracker2);
    }
}