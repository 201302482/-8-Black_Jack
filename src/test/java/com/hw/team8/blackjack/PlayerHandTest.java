package com.hw.team8.blackjack;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by com on 2017-06-08.
 */
public class PlayerHandTest {

    @Test
    public void hand에_카드를_2장추가하였다면_size는_2이다(){
        PlayerHand playerHand = new PlayerHand();
        Card card = new Card(1,Suit.CLUBS);
        playerHand.addCard(card);
        assertThat(playerHand.getHand().size(), is(2));
    }

    @Test
    public void hand를_클리어하였다면_size는_0이다(){
        PlayerHand playerHand = new PlayerHand();
        Card card1 = new Card(1,Suit.CLUBS);
        Card card2 = new Card(3,Suit.DIAMONDS);
        playerHand.addCard(card1);
        playerHand.addCard(card2);
        playerHand.clear();
        assertThat(playerHand.getHand().size(), is(0));
    }
}
