package com.hw.team8.blackjack;

import lombok.Data;

/**
 * Created by com on 2017-06-08.
 */


@Data
public class Card {
    private int rank;
    private Suit suit;

    public Card(int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;//rank값이 11보다 클 경우 예외처리해야함
    }


    public int getRank() {
        return rank;
    }
}
