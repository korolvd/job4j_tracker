package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.print("The " + getClass().getSimpleName() + " is moving on rails");
    }

    @Override
    public String speed() {
        return "high speed";
    }
}
