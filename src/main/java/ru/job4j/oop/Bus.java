package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.print("The " + getClass().getSimpleName() + " is moving on highway");
    }

    @Override
    public String speed() {
        return "low speed";
    }
}
