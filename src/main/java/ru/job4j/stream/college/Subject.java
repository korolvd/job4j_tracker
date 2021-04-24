package ru.job4j.stream.college;

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

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

    @Override
    public String toString() {
        return "Subject{"
                + "name='" + name + '\''
                + ", score=" + score
                + '}';
    }
}
