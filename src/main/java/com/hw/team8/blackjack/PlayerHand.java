package com.hw.team8.blackjack;

import java.util.Vector;

/**
 * Created by com on 2017-06-08.
 */
public class PlayerHand {
    private Vector<Card> hand;   // The cards in the hand.

    public PlayerHand() {
        hand = new Vector<Card>();
    }

    public Vector<Card> getHand(){
        return hand;
    }

    public void addCard(Card c) {
        hand.addElement(c);
    }

    public void clear() {
        hand.removeAllElements();
    }

    public void removeCard(Card card) {
        hand.removeElement(card);
    }

    public void removeCard(int position) {
        if (position >= 0 && position < hand.size())
            hand.removeElementAt(position);
    }

    public Card getCard(int position) {
        if (position >= 0 && position < hand.size())
            return (Card)hand.elementAt(position);
        else
            throw new NoSuchCardException();
    }

    public int getCardCount() {
        return hand.size();
    }



    public void sortBySuit() {

    }

    public void sortByValue() {

    }

    public String toString(){

        return "";
    }
}
