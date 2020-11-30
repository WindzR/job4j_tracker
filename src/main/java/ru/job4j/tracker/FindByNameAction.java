package ru.job4j.tracker;

public class FindByNameAction implements UserAction {

    @Override
    public String name() {
        return "==== Find by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] findByName = tracker.findByName(name);
        if (findByName.length > 0) {
            System.out.println("==== Item ====");
            for (Item i : findByName) {
                System.out.println(i);
            }
        } else {
            System.out.println("Error! Can't find this item!");
        }
        return true;
    }
}
