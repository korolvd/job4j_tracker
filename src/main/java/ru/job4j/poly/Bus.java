package ru.job4j.poly;

public class Bus implements Transport {
    private String point;
    private int passengers;
    private double price;

    @Override
    public void ride() {
        System.out.println(point);
    }

    @Override
    public void passengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public double fill(int litres) {
        return price * litres;
    }
}
