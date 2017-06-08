package com.hw.team8.blackjack;

/**
 * Created by com on 2017-06-08.
 */
public class Player extends PlayerHand {

    public int getBlackjackRank(){

        int val = 0;
        boolean ace = false;
        int cards = getCardCount();

        for( int i=0; i< cards; i++){
            Card card = getCard(i);
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

}
