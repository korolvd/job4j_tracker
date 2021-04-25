package ru.job4j.map;

import java.util.Objects;

public class Subject {
    private String name;

    private int score;

    public Subject(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this != o) {
            if (o != null && getClass() == o.getClass()) {
                Subject subject = (Subject) o;
                return Objects.equals(name, subject.name);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}