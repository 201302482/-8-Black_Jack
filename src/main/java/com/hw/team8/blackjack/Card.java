package com.hw.team8.blackjack;

import lombok.Data;
/**
 * Created by com on 2017-06-08.
 */
@Data
class Card implements Comparable<Card>{

    private int rank;
    private Suit suit;

    public Card(int theRank, Suit theSuit){
        rank = theRank;
        suit = theSuit;
        if (theRank > 13){
            throw new NoSuchRankException();
        }
    }

    public int compareTo(Card o){
        return this.getRank() - o.getRank();
    }

}
