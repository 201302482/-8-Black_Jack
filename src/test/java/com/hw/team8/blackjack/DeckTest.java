package com.hw.team8.blackjack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by com on 2017-06-08.
 */
public class DeckTest {
    @Test
    public void 덱_만들기(){
        Deck deck = new Deck();
        assertThat(deck.size(),is(52));
    }
    @Test
    public void 덱_셔플하기(){
        Deck deck = new Deck();
        Deck shuffledDeck = new Deck();
        shuffledDeck.shuffle();
        System.out.println(deck.getDeck());
        System.out.println(shuffledDeck.getDeck());
    }
}
