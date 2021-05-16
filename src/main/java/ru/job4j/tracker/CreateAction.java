package ru.job4j.tracker;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "==== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        memTracker.add(item);
        out.println("Item has been successfully created!");
        return true;
    }
}
