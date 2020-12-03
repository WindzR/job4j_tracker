package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "==== Find by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] findByName = tracker.findByName(name);
        if (findByName.length > 0) {
            out.println("==== Item ====");
            for (Item i : findByName) {
                out.println(i);
            }
        } else {
            out.println("Error! Can't find this item!");
        }
        return true;
    }
}
