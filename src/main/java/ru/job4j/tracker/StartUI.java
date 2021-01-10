package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        item.setName("Tracker - хранилище");
        Tracker tracker = new Tracker();
        tracker.add(item);
        Item exist = tracker.findById(1);
        System.out.println(exist.getId() + ". " + exist.getName());
    }
}
