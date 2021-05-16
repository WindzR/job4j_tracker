package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "==== Delete item ====";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        int id = input.askInt("Enter id delete item: ");
        if (memTracker.delete(id)) {
            out.println("Item has been successfully deleted!");
        } else {
            out.println("Error! Can't find this item!");
        }
        return true;
    }
}
