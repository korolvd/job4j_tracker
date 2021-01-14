package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showItems(Tracker tracker) {
        Item[] items = tracker.findAll();
        System.out.println(System.lineSeparator() + "ID NAME");
        for (Item item : items) {
            System.out.println(item.getId() + " " + item.getName());
        }
        System.out.println();
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit Item ====");
        int id = input.askInt("Enter Id: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Successfully!" + System.lineSeparator());
        } else {
            System.out.println("Error!" + System.lineSeparator());
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        int id = input.askInt("Enter Id: ");
        if (tracker.delete(id)) {
            System.out.println("Successfully!" + System.lineSeparator());
        } else {
            System.out.println("Error!" + System.lineSeparator());
        }
    }

    public static void findById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        int id = input.askInt("Enter Id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item.getName() + System.lineSeparator());
        } else {
            System.out.println("Not found." + System.lineSeparator());
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            System.out.println(System.lineSeparator() + "ID NAME");
            for (Item item : items) {
                System.out.println(item.getId() + " " + item.getName());
            }
        } else {
            System.out.println("Not found." + System.lineSeparator());
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
                StartUI.showItems(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
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
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}