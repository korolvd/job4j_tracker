package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
        return true;
    }
}
