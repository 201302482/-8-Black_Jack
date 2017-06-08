package com.hw.team8.blackjack;

/**
 * Created by com on 2017-06-08.
 */
public enum Suit {
    SPADES(0),
    HEARTS(1),
    CLUBS(2),
    DIAMONDS(3);

    private int suit;

    Suit(int suit) {
        this.suit = suit;
    } //construtor
    public int getSuitValue() {
        return this.suit;
    }
}
