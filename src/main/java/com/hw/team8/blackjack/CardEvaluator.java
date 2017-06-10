package com.hw.team8.blackjack;

/**
 * Created by com on 2017-06-08.
 */
public class CardEvaluator {

    public int getBlackjackRank(Player player){
        int val = 0;
        boolean ace = false;
        PlayerHand  playerHand = player.getPlayerHand();
        int cards = playerHand.getCardCount();

        for( int i=0; i< cards; i++){
            Card card = playerHand.getCard(i);
            int cardVal = card.getRank();
            if(cardVal > 10){
                cardVal = 10;
            }
            if(cardVal == 1){
                ace = true;
            }
            val = val + cardVal;
        }

        if(ace == true && val + 10 <= 21)
            val = val+10;

        return val;
    }

    public GameResult getGameResult(Player player, Player dealer) {
        if (getBlackjackRank(dealer) == getBlackjackRank(player)) {
            return GameResult.DRAW;
        }
        else if (getBlackjackRank(dealer) > getBlackjackRank(player)) {
            System.out.println("Dealer wins, " + getBlackjackRank(dealer)
                    + " points to " + getBlackjackRank(player) + ".");
            return GameResult.LOSE;
        }
        else {
            System.out.println("You win, " + getBlackjackRank(player)
                    + " points to " + getBlackjackRank(dealer) + ".");
            return GameResult.WIN;
        }
    }

}
