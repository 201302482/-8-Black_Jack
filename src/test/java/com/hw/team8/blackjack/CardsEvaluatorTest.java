package com.hw.team8.blackjack;

import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by com on 2017-06-08.
 */
public class CardsEvaluatorTest {

    @Test
    public void 결과값이_21보다_크다() {
        Card card1 = new Card(5, Suit.DIAMONDS);
        Card card2 = new Card(8, Suit.HEARTS);
        Card card3 = new Card(10, Suit.DIAMONDS);

        int result = card1.getRank() + card2.getRank() + card3.getRank();
        assertTrue(result > 21);
    }
}