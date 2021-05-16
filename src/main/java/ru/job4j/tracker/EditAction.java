package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "==== Edit item ====";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        int id = input.askInt("Enter id edit item: ");
        String name = input.askStr("Enter new name item: ");
        Item item = new Item(name);
        if (memTracker.replace(id, item)) {
            out.println("Item has been edit successfully!");
        } else {
            out.println("Error! Can't find this item!");
        }
        return true;
    }
}
