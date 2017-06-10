package com.hw.team8.blackjack;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by com on 2017-06-08.
 */
public class EvaluatorTest {

    @Test
    public void 가지고있는_카드의_합은19다(){
        CardEvaluator cardEvaluator = new CardEvaluator();
        Player player = new Player(new PlayerHand());
        player.getPlayerHand().addCard(new Card(9,Suit.HEARTS));
        player.getPlayerHand().addCard(new Card(10,Suit.SPADES));

        assertThat(cardEvaluator.getBlackjackRank(player), is(19));
    }

    @Test
    public void 가지고있는_카드의_합은21다(){
        CardEvaluator cardEvaluator = new CardEvaluator();
        Player player = new Player(new PlayerHand());
        player.getPlayerHand().addCard(new Card(1,Suit.HEARTS));
        player.getPlayerHand().addCard(new Card(10,Suit.SPADES));

        assertThat(cardEvaluator.getBlackjackRank(player), is(21));
    }
}
