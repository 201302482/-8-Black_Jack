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
        Player player = new Player(new PlayerHand());
        Card card1 = new Card(10,Suit.SPADES);
        Card card2 = new Card(9,Suit.HEARTS);
        CardEvaluator cardEvaluator = new CardEvaluator();

        player.getPlayerHand().addCard(card2);
        player.getPlayerHand().addCard(card1);
        assertThat(cardEvaluator.getBlackjackRank(player), is(19));
    }

    @Test
    public void Player가_가지고있는_카드의_합은21다(){
        Player player = new Player(new PlayerHand());
        Card card1 = new Card(1,Suit.SPADES);
        Card card2 = new Card(10,Suit.HEARTS);
        CardEvaluator cardEvaluator = new CardEvaluator();

        player.getPlayerHand().addCard(card2);
        player.getPlayerHand().addCard(card1);
        assertThat(cardEvaluator.getBlackjackRank(player), is(21));
    }
;}
