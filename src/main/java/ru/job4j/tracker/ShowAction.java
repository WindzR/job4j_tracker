package ru.job4j.tracker;

import java.util.List;

public class ShowAction implements UserAction {
    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "==== List of Items ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        List<Item> allItems = tracker.findAll();
        for (Item i : allItems) {
            out.println(i);
        }
        return true;
    }
}
