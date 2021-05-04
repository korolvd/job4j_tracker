package ru.job4j.stream.certificate;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(-1);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(p -> new Tuple(p.getName(), p.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .average().getAsDouble()))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(p -> new Tuple(p.getName(), p.getSubjects()
                        .stream().mapToInt(Subject::getScore).sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }
}
