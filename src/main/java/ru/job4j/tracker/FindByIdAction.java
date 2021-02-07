package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        int id = input.askInt("Enter Id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item.getName() + System.lineSeparator());
        } else {
            System.out.println("Not found." + System.lineSeparator());
        }
        return true;
    }
}
