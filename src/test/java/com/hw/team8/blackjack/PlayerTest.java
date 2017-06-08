package com.hw.team8.blackjack;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by com on 2017-06-08.
 */
public class PlayerTest {

    @Test
    public void Player가_가지고있는_카드의_합은19다(){
        Player playerHand = new Player();
        Card card1 = new Card(10,Suit.SPADES);
        Card card2 = new Card(9,Suit.HEARTS);

        playerHand.addCard(card2);
        playerHand.addCard(card1);
        assertThat(playerHand.getBlackjackRank(), is(19));
    }
}
