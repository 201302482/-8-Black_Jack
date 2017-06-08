package com.hw.team8.blackjack;

import lombok.Data;

import java.util.Vector;

/**
 * Created by com on 2017-06-08.
 */
@Data
public class PlayerHand {
    private Vector<Card> hand;   // The cards in the hand.

    public PlayerHand() {
        hand = new Vector<Card>();
    }

    public void addCard(Card c) {
        hand.addElement(c);
    }

    public void clear() {
        hand.removeAllElements();
    }

    public void removeCard(Card c) {

    }

    public void removeCard(int position) {

    }

    public int getCardCount() {

        return 0;
    }

    public Card getCard(int position) {

        return null;
    }

    public void sortBySuit() {

    }

    public void sortByValue() {

    }

    public String toString(){

        return "";
    }
}
