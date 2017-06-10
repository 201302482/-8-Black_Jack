package com.hw.team8.blackjack;

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
    }
}
