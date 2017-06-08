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
            return hand.elementAt(position);
        else
            throw new NoSuchCardException();
    }

    public int getCardCount() {
        return hand.size();
    }

    public void sortBySuit() {
        Vector<Card> newHand = new Vector<Card>();
        while (hand.size() > 0) {
            int pos = 0;  // Position of minimal card.
            Card card1 = hand.elementAt(0);  // Minumal card.
            for (int i = 1; i < hand.size(); i++) {
                Card card2 = hand.elementAt(i);
                if ( card2.getSuit().getSuitValue() < card1.getSuit().getSuitValue() ||
                        (card2.getSuit() == card1.getSuit() && card2.getRank() < card1.getRank()) ) {
                    pos = i;
                    card1 = card2;
                }
            }
            hand.removeElementAt(pos);
            newHand.addElement(card1);
        }
        hand = newHand;
    }

    public void sortByValue() {

    }

    public String toString(){

        return "";
    }
}
