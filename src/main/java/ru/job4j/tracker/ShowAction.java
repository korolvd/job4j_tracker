package ru.job4j.tracker;

public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "Show all Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Show all Items ====");
        Item[] items = tracker.findAll();
        System.out.println(System.lineSeparator() + "ID NAME");
        for (Item item : items) {
            System.out.println(item.getId() + " " + item.getName());
        }
        System.out.println();
        return true;
    }
}
