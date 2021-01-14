package ru.job4j.oop;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.print("The " + getClass().getSimpleName() + " is flying");
    }

    @Override
    public String speed() {
        return "very high speed";
    }
}
