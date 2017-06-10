package com.hw.team8.blackjack;

/**
 * Created by com on 2017-06-08.
 */
import lombok.Data;

@Data
public class Player {

    private PlayerHand playerHand;

    public Player(PlayerHand hand){
        this.playerHand = hand;
    }
}
