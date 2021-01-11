package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        int num = new Random().nextInt(3);
        String[] answer = {"Да", "Нет", "Может быть"};
        Scanner in = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        in.nextLine();
        System.out.println(answer[num]);
    }
}
