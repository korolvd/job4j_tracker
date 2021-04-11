package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ItemTest {
    @Test
    public void whenSortByName() {
        List<Item> items = Arrays.asList(
                new Item("Second"),
                new Item("First")
        );
        String expect = "First";
        Collections.sort(items, new SortItemByName());
        assertThat(items.get(0).getName(), is(expect));
    }

    @Test
    public void whenReversSortByName() {
        List<Item> items = Arrays.asList(
                new Item("First"),
                new Item("Second")
        );
        String expect = "Second";
        Collections.sort(items, new ReversSortItemByName());
        assertThat(items.get(0).getName(), is(expect));
    }

}