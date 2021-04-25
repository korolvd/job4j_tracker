package ru.job4j.collection.departments;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int cmp = o2.split("/")[0].compareTo(o1.split("/")[0]);
        return cmp != 0 ? cmp : o1.compareTo(o2);
    }
}
