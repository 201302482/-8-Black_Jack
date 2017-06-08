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
        assertThat(deck.cardsLeft(),is(52));
    }
    @Test
    public void 덱_셔플하기(){
        Deck deck = new Deck();
        Deck shuffledDeck = new Deck();
        shuffledDeck.shuffle();
        System.out.println(deck.getDeck());
        System.out.println(shuffledDeck.getDeck());
    }
    @Test
    public void 덱에서_카드_한장_가져오기(){
        Deck deck = new Deck();
        deck.dealCard();
        assertThat(deck.cardsLeft(),is(51));
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
