package ru.job4j.tracker;

public class EditAction implements UserAction {

    @Override
    public String name() {
        return "==== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id edit item: ");
        String name = input.askStr("Enter new name item: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Item has been edit successfully!");
        } else {
            System.out.println("Error! Can't find this item!");
        }
        return true;
    }
}
