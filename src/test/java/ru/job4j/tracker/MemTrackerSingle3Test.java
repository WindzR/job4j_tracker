package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class MemTrackerSingle3Test {

    @Test
    public void getInstance() {
        MemTracker memTracker = TrackerSingle3.getInstance();
        MemTracker memTracker2 = TrackerSingle3.getInstance();
        assertSame(memTracker, memTracker2);
    }
}