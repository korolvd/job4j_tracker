package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Suit {
    Diamonds, Hearts, Spades, Clubs
}

enum Value {
    V_6, V_7, V_8
}

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        List<Card> cards = Stream.of(Value.values())
                .flatMap(v -> Stream.of(Suit.values())
                        .map(s -> new Card(s, v)))
                .collect(Collectors.toList());
        for (Card card : cards) {
            System.out.println(card.value + " " + card.suit);
        }
    }
}


