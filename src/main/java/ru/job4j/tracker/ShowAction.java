package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class ShowAction implements UserAction {
    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all Items ====");
        List<Item> items = tracker.findAll();
        out.println(System.lineSeparator() + "ID NAME");
        for (Item item : items) {
            out.println(item.getId() + " " + item.getName());
        }
        return true;
    }
}
