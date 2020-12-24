package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        size++;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findByAll() {
        return items;
    }

    public List<Item> findByName(String name) {
        List<Item> rsl = new ArrayList<>();
        for (int index = 0; index < this.size; index++) {
            Item item = items.get(index);
            if (item.getName().equals(name)) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        if (!items.isEmpty()) {
            for (int index = 0; index < size; index++) {
                if (items.get(index).getId() == id) {
                    rsl = index;
                    break;
                }
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean exeption = index != -1;
        if (exeption) {
            items.set(index, item);
            item.setId(id);
        }
        return exeption;
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
    public String toString() {
        return "Tracker{" +
                "items=" + items +
                ", ids=" + ids +
                ", size=" + size +
                '}';
    }
}