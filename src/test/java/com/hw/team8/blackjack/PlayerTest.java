package com.hw.team8.blackjack;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

/**
 * Created by com on 2017-06-08.
 */
public class PlayerTest {
    @Test
    public void Player는_2개의_카드를_가지고있다(){
        Player player = new Player(new PlayerHand());
        player.getPlayerHand().addCard(new Card(9,Suit.HEARTS));
        player.getPlayerHand().addCard(new Card(10,Suit.SPADES));

        MatcherAssert.assertThat(player.getPlayerHand().getCardCount(), is(2));
    }

    @Test
    public void Player는_3개의_카드를_가지고있다(){
        Player player = new Player(new PlayerHand());
        player.getPlayerHand().addCard(new Card(5,Suit.HEARTS));
        player.getPlayerHand().addCard(new Card(10,Suit.SPADES));
        player.getPlayerHand().addCard(new Card(1,Suit.DIAMONDS));

        MatcherAssert.assertThat(player.getPlayerHand().getCardCount(), is(3));
    }

;}
