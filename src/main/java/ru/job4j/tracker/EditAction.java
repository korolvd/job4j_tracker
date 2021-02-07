package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Edit Item ====");
        int id = input.askInt("Enter Id: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Successfully!" + System.lineSeparator());
        } else {
            System.out.println("Error!" + System.lineSeparator());
        }
        return true;
    }
}
