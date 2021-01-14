package ru.job4j.oop;

public class VehiclesType {
    public static void main(String[] args) {
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle plane = new Plane();
        Vehicle[] vehicles = new Vehicle[]{train, bus, plane};
        for (Vehicle a: vehicles) {
            a.move();
            System.out.println(" with a " + a.speed());
        }
    }
}
