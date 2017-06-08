package com.hw.team8.blackjack;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by com on 2017-06-08.
 */
@Data
public class Deck {
    private ArrayList<Card> deck;
    private int cardsUsed;
    public Deck(){
        cardsUsed = 0;
        deck = new ArrayList<Card>();
        for(Suit suit : Suit.values()){
            for(int rank=1; rank<=13; rank++){
                deck.add(new Card(rank,suit));
            }
        }
    }
    public void shuffle(){
        Collections.shuffle(deck);
    }
    public Card dealCard(){
        if(cardsLeft() == 52){
            shuffle();
        }
        return deck.remove(0);
    }
    public int cardsLeft() {
        return this.deck.size();
    }

}
