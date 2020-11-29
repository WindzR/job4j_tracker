package ru.job4j.tracker;

public class FindByIdAction implements UserAction {

    @Override
    public String name() {
        return "==== Find by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("==== Item ====");
            System.out.println(item);
        } else {
            System.out.println("Error! Can't find this item!");
        }
        return true;
    }
}
