package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterInteger {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, -23, 132, -45, 2324));
        List<Integer> filterList = list.stream().filter(
                integer -> integer >= 0
        ).collect(Collectors.toList());
        System.out.println(filterList);
    }
}
