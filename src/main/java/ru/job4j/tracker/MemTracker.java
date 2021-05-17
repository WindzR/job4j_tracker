package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public void init() {
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String name) {
        List<Item> rsl = new ArrayList<>();
        for (Item value : items) {
            if (value.getName().equals(name)) {
                rsl.add(value);
            }
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        int index = 0;
        if (!items.isEmpty()) {
            for (Item value : items) {
                if (value.getId() == id) {
                    rsl = index;
                    break;
                }
                index++;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean exception = index != -1;
        if (exception) {
            items.set(index, item);
            item.setId(id);
        }
        return exception;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean exeption = index != -1;
        if (exeption) {
            items.remove(index);
        }
         return exeption;
    }

    @Override
    public void close() {
    }
}