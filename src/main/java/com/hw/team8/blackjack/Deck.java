package com.hw.team8.blackjack;

import lombok.Data;

/**
 * Created by com on 2017-06-08.
 */
@Data
public class Deck {
    private Card[] deck;
    private int cardsUsed;
    public Deck(){
        cardsUsed = 0;
        deck = new Card[52];
        for(Suit suit : Suit.values()){
            for(int card_index=1; card_index<=13; card_index++){
                deck[card_index] = new Card(card_index,suit);
            }
        }
    }
    public int size() {
        return this.deck.length - cardsUsed;
    }
}
