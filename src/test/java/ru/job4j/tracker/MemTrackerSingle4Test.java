package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class MemTrackerSingle4Test {

    @Test
    public void getInstance() {
        MemTracker memTracker = TrackerSingle4.getInstance();
        MemTracker memTracker2 = TrackerSingle4.getInstance();
        assertSame(memTracker, memTracker2);
    }
}