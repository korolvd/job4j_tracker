package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Владимир Владимирович Пушкин");
        student.setGroup(14453);
        student.setDate(2020, 12, 02);
        System.out.println(student.getName() + " группа: " + student.getGroup() +
                " дата поступления: " + student.getDate());
    }
}
