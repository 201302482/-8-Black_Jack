package com.hw.team8.blackjack;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by com on 2017-06-08.
 */
public class DeckTest {
    @Test
    public void 덱_만들기(){
        Deck deck = new Deck();
        assertThat(deck.cardsLeft(),is(52));
    }
}
