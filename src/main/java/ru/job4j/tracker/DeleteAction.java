package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    @Override
    public String name() {
        return "==== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id delete item: ");
        if (tracker.delete(id)) {
            System.out.println("Item has been successfully deleted!");
        } else {
            System.out.println("Error! Can't find this item!");
        }
        return true;
    }
}
