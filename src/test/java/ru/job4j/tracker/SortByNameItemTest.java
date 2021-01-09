package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class SortByNameItemTest {

    @Test
    public void compareItemByIncrease() {
        List<Item> items = Arrays.asList(
                new Item(1, "Frodo"),
                new Item(2, "Eugene"),
                new Item(3, "Alex")
        );
        Collections.sort(items, new SortByNameItem());
        assertThat(new String[] {items.get(0).getName(), items.get(1).getName(),
                        items.get(2).getName()},
                is(new String[] {"Alex", "Eugene", "Frodo"}));
    }

    @Test
    public void compareItemByDecrease() {
        List<Item> items = Arrays.asList(
                new Item(1, "Alex"),
                new Item(2, "Boris"),
                new Item(3, "Constantin")
        );
        Collections.sort(items, new DecreaseByNameItem());
        assertThat(new String[] {items.get(0).getName(), items.get(1).getName(),
                        items.get(2).getName()},
                is(new String[] {"Constantin", "Boris", "Alex"}));
    }
}