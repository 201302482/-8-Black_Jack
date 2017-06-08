package com.hw.team8.blackjack;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by com on 2017-06-08.
 */
public class CardTest {

    @Test
    public void 카드_5_다이아몬드_생성() {
        Card card = new Card(5, Suit.DIAMONDS);
        assertThat(card.getRank(), is(5));
        assertThat(card.getSuit(), is(Suit.DIAMONDS));
    }

    @Test(expected = NoSuchRankException.class)
    public void 카드의_랭크는_13이하여야한다() {
        new Card(14, Suit.CLUBS);
    }

}
