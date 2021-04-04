package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> users = new HashMap<>();
        users.put("ivanov.v@email.com", "Ivanov Vasilii");
        users.put("sidorov.v@email.com", "Sidorov Vasilii");
        users.put("petrov.v@email.com", "Petrov Vasilii");
        users.put("aleksandrov.v@email.com", "Aleksandrov Vasilii");
        for (String key : users.keySet()) {
            String value = users.get(key);
            System.out.println(key + " " + value);
        }
    }
}
