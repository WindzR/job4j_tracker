package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class MemTrackerSingle2Test {

    @Test
    public void getInstance() {
        MemTracker memTracker = TrackerSingle2.getInstance();
        MemTracker memTracker2 = TrackerSingle2.getInstance();
        assertSame(memTracker, memTracker2);
    }
}