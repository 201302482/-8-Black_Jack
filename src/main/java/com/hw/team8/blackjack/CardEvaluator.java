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

    public GameResult isBlackJack(Player player, Player dealer){
        if(getBlackjackRank(dealer) == 21){
            print_TwoCards(player, dealer);
            System.out.println("Dealer has Blackjack.  Dealer wins.");
            return GameResult.LOSE;
        }
        else if (getBlackjackRank(player) == 21) {
            print_TwoCards(player, dealer);
            System.out.println("You have Blackjack.  You win.");
            return GameResult.WIN;
        }
        return null;
    }

    private void print_TwoCards(Player player, Player dealer) {
        System.out.println("Dealer has the " + dealer.getPlayerHand().getCard(0)
                + " and the " + dealer.getPlayerHand().getCard(1) + ".");
        System.out.println("User has the " + player.getPlayerHand().getCard(0)
                + " and the " + player.getPlayerHand().getCard(1) + ".");
        System.out.println();
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
