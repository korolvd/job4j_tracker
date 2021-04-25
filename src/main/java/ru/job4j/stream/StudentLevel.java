package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(s -> s != null)
                .sorted((l, r) -> Integer.compare(r.getScore(), l.getScore()))
                .takeWhile(s -> s.getScore() > bound)
                .collect(Collectors.toList());
    }
}
