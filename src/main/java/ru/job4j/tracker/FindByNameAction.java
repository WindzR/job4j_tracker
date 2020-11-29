package ru.job4j.tracker;

import java.util.Arrays;

public class FindByNameAction implements UserAction {

    @Override
    public String name() {
        return "==== Find by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        if (tracker.findByName(name).length > 0) {
            System.out.println("==== Item ====");
            System.out.println(Arrays.toString(tracker.findByName(name)));
        } else {
            System.out.println("Error! Can't find this item!");
        }
        return true;
    }
}
