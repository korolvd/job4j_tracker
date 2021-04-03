package ru.job4j.tracker;

public class ConsoleOutpot implements Output {

    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
}
