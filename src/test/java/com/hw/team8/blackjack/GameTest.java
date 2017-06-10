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
        assertThat(game.getPlayerMoney(), is(100));
    }

    @Test
    public void 플레이어의_카드가_21이면_이긴다() {
        Game game = new Game();

        PlayerHand playerHand = game.getPlayer().getPlayerHand();
        PlayerHand dealerHand = game.getDealer().getPlayerHand();
        playerHand.addCard(new Card(1,Suit.DIAMONDS));
        playerHand.addCard(new Card(10,Suit.DIAMONDS));
        dealerHand.addCard(new Card(4,Suit.DIAMONDS));
        dealerHand.addCard(new Card(2,Suit.CLUBS));
        assertThat(game.isBlackJack(), is(GameResult.WIN));
    }
    @Test
    public void Player가_이겼다() {
        Game game = new Game();
        PlayerHand playerHand = game.getPlayer().getPlayerHand();
        PlayerHand dealerHand = game.getDealer().getPlayerHand();

        Card playercard1 = new Card(10,Suit.CLUBS);
        Card playercard2 = new Card(11,Suit.HEARTS);
        Card dealercard1 = new Card(4,Suit.DIAMONDS);
        Card dealercard2 = new Card(12,Suit.SPADES);
        playerHand.addCard(new Card(10, Suit.CLUBS));
        playerHand.addCard(new Card(3, Suit.DIAMONDS));
        dealerHand.addCard(new Card(2, Suit.HEARTS));
        dealerHand.addCard(new Card(2, Suit.CLUBS));
        CardEvaluator cardEvaluator = new CardEvaluator();

        boolean result = false;
        if(cardEvaluator.getBlackjackRank(game.getPlayer()) > cardEvaluator.getBlackjackRank(game.getDealer())) {
            result = true;
        }

        assertThat(true, is(result));
    }



    @Test
    public void Player가_졌다() {
        Game game = new Game();
        PlayerHand playerHand = game.getPlayer().getPlayerHand();
        PlayerHand dealerHand = game.getDealer().getPlayerHand();
        Card playercard1 = new Card(10,Suit.CLUBS);
        Card playercard2 = new Card(11,Suit.HEARTS);
        Card playercard3 = new Card(5,Suit.HEARTS);
        Card dealercard1 = new Card(4,Suit.DIAMONDS);
        Card dealercard2 = new Card(12,Suit.SPADES);
        Card dealercard3 = new Card(5,Suit.SPADES);
        CardEvaluator cardEvaluator = new CardEvaluator();

        playerHand.addCard(playercard1);
        playerHand.addCard(playercard2);
        playerHand.addCard(playercard3);
        dealerHand.addCard(dealercard1);
        dealerHand.addCard(dealercard2);
        dealerHand.addCard(dealercard3);
        boolean result = false;
        if(cardEvaluator.getBlackjackRank(game.getPlayer()) > 21) {
            result = true;
        }

        assertThat(true, is(result));
    }
}
