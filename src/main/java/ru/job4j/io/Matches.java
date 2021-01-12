package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    private int matches;

    public Matches(int matches) {
        this.matches = matches;
    }

    public int getMatches() {
        return matches;
    }

    public boolean take(int quant) {
        boolean rsl = matches >= quant
                && quant > 0 && quant < 4;
        if (rsl) {
            matches = matches - quant;
        }
        return rsl;
    }

    public void score() {
        for (int i = 0; i < matches; i++) {
            System.out.print("| ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean game = true;
        int player = 1;
        int index = 1;
        Matches matches = new Matches(11);
        Scanner in = new Scanner(System.in);
        matches.score();
        while (game) {
            System.out.print("Ход игрока " + player + ": ");
            if (matches.take(in.nextInt())) {
                player += index;
                index *= -1;
                if (matches.getMatches() == 0) {
                    game = false;
                }
            } else {
                System.out.println("Нельзя забрать столько спичек. Повторите попытку");
            }
            matches.score();
        }
        System.out.println("Спички кончились. Победитель игрок " + player + "!");
    }
}
