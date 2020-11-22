package ru.job4j.tracker;

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
                Item item = new Item(1, name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("==== List of Items ====");
                Item[] allItems = tracker.findByAll(new Item[]);
                for ( i : allItems) {
                    System.out.println(i);
                }
            } else if (select == 2) {
                System.out.println("==== Edit item ====");
            } else if (select == 3) {
                System.out.println("==== Delete item ====");
            } else if (select == 4) {
                System.out.println("==== Find by Id ====");
                System.out.println("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
            } else if (select == 5) {
                System.out.println("==== Find by name ====");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
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
