package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> predAdress = (p) -> p.getAddress().contains(key);
        Predicate<Person> predPhone = (p) -> p.getPhone().contains(key);
        Predicate<Person> predName = (p) -> p.getName().contains(key);
        Predicate<Person> predSurname = (p) -> p.getSurname().contains(key);
        Predicate<Person> combine = predAdress
                .or(predPhone)
                .or(predName)
                .or(predSurname);
        ArrayList<Person> result = new ArrayList<>();
        for (Person value : persons) {
            if (combine.test((value))) {
                result.add(value);
            }
        }
        return result;
    }
}