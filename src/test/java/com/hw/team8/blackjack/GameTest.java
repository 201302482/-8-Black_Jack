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
    public void 플레이어의_카드가_21이면_이긴다(){
        Game game = new Game();
        Player player = new Player(new PlayerHand());
        Player dealer = new Player(new PlayerHand());
        player.getPlayerHand().addCard(new Card(10,Suit.CLUBS));
        player.getPlayerHand().addCard(new Card(1,Suit.DIAMONDS));
        dealer.getPlayerHand().addCard(new Card(2,Suit.HEARTS));
        dealer.getPlayerHand().addCard(new Card(2,Suit.CLUBS));
        dealer.getPlayerHand().addCard(new Card(2,Suit.SPADES));
        assertThat(game.isBlackJack(player,dealer),is(GameResult.LOSE));
      
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
