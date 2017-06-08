package com.hw.team8.blackjack;

/**
 * Created by com on 2017-06-08.
 */
public enum GameResult {
    WIN(0),
    DRAW(1),
    LOSE(2);

    private int gameResult;

    GameResult(int result) {
        this.gameResult = result;
    } //construtor
    public int getGameResult() {
        return this.gameResult;
    }
}

