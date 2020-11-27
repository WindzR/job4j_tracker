package ru.job4j.tracker;

import java.util.Arrays;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Item has been successfully created!");
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println("==== List of Items ====");
        Item[] allItems = tracker.findByAll();
        for ( Item i : allItems) {
            System.out.println(i);
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("==== Edit item ====");
        int id = input.askInt("Enter id edit item: ");
        String name = input.askStr("Enter new name item: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Item has been edit successfully!");
        } else {
            System.out.println("Error! Can't find this item!");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("==== Delete item ====");
        int id = input.askInt("Enter id delete item: ");
        if (tracker.delete(id)) {
            System.out.println("Item has been successfully deleted!");
        } else {
            System.out.println("Error! Can't find this item!");
        }
    }

    public static void findById(Input input, Tracker tracker) {
        System.out.println("==== Find by Id ====");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("==== Item ====");
            System.out.println(item);
        } else {
            System.out.println("Error! Can't find this item!");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        System.out.println("==== Find by name ====");
        String name = input.askStr("Enter name: ");
        if (tracker.findByName(name).length > 0) {
            System.out.println("==== Item ====");
            System.out.println(Arrays.toString(tracker.findByName(name)));
        } else {
            System.out.println("Error! Can't find this item!");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
               StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(tracker);
            } else if (select == 2) {
               StartUI.editItem(input, tracker);
            } else if (select == 3) {
               StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findById(input, tracker);
            } else if (select == 5) {
              StartUI.findByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0.Add new Item");
        System.out.println("1.Show all Items");
        System.out.println("2.Edit item");
        System.out.println("3.Delete item");
        System.out.println("4.Find item by Id");
        System.out.println("5.Find item by name");
        System.out.println("6.Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
