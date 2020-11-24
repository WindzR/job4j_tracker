package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("==== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Item has been successfully created!");
            } else if (select == 1) {
                System.out.println("==== List of Items ====");
                Item[] items = new Item[100];
                Item[] allItems = tracker.findByAll(items);
                for ( Item i : allItems) {
                    System.out.println(i);
                }
            } else if (select == 2) {
                System.out.println("==== Edit item ====");
                System.out.println("Enter id edit item: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter new name item: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.replace(id, item);
                if (tracker.replace(id, item)) {
                    System.out.println("Item has been edit successfully!");
                } else {
                    System.out.println("Error! Can't to find this item!");
                }
            } else if (select == 3) {
                System.out.println("==== Delete item ====");
                System.out.println("Enter id delete item: ");
                int id = Integer.parseInt(scanner.nextLine());
                tracker.delete(id);
                if (tracker.delete(id)) {
                    System.out.println("Item has been successfully deleted!");
                } else {
                    System.out.println("Error! Can't to find this item!");
                }
            } else if (select == 4) {
                System.out.println("==== Find by Id ====");
                System.out.println("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = new Item();
                item = tracker.findById(id);
                if (item != null) {
                    System.out.println("==== Item ====");
                    System.out.println(item);
                } else {
                    System.out.println("Error! Can't to find this item!");
                }
            } else if (select == 5) {
                System.out.println("==== Find by name ====");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                if (tracker.findByName(name) != null) {
                    System.out.println("==== Item ====");
                    System.out.println(Arrays.toString(tracker.findByName(name)));
                } else {
                    System.out.println("Error! Can't to find this item!");
                }
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
