package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            out.println(System.lineSeparator() + "ID NAME");
            for (Item item : items) {
                out.println(item.getId() + " " + item.getName());
            }
        } else {
            out.println("Not found." + System.lineSeparator());
        }
        return true;
    }
}
