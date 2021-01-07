package ru.job4j.oop;

import static java.lang.Math.sqrt;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double period() {
        double ab = this.first.distance(this.second);
        double ac = this.first.distance(this.third);
        double bc = this.second.distance(this.third);
        return (ab + bc + ac) / 2;
    }

    public boolean exist() {
        double ab = this.first.distance(this.second);
        double ac = this.first.distance(this.third);
        double bc = this.second.distance(this.third);
        return (ab + ac) > bc && (ac + bc) > ab && (ab + bc) > ac;
    }

    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        double p = this.period();
        if (this.exist()) {
            rsl = sqrt(p * (p - ab) * (p - bc) * (p - ac));
        }
        return rsl;
    }
}