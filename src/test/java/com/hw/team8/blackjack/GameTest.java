package com.hw.team8.blackjack;


import org.hamcrest.Matcher;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by com on 2017-06-08.s
 */
public class GameTest {

    @Test
    public void 시작_금액은_100달러이다() {
        Game game = new Game();
        assertThat(game.getMoney(), is(100));
    }

    @Test
    public void Player가_이겼다() {
        Player player = new Player(new PlayerHand());
        Player dealer = new Player(new PlayerHand());
        Card playercard1 = new Card(10,Suit.CLUBS);
        Card playercard2 = new Card(1,Suit.HEARTS);
        Card dealercard1 = new Card(4,Suit.DIAMONDS);
        Card dealercard2 = new Card(12,Suit.SPADES);
        CardEvaluator cardEvaluator = new CardEvaluator();

        player.getPlayerHand().addCard(playercard1);
        player.getPlayerHand().addCard(playercard2);
        dealer.getPlayerHand().addCard(dealercard1);
        dealer.getPlayerHand().addCard(dealercard2);

        boolean result = false;
        if(cardEvaluator.getBlackjackRank(player) > cardEvaluator.getBlackjackRank(dealer)) {
            result = true;
        }

        assertThat(true, is(result));
    }
}
