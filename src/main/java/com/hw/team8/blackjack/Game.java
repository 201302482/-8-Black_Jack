package com.hw.team8.blackjack;

import java.util.Scanner;

/**
 * Created by com on 2017-06-08.
 */
public class Game {
    Scanner scanner;
    int money;
    int bet;
    GameResult userWins;

    public Game(){
        scanner = new Scanner(System.in);
        money = 100;
    }
    public void start() {
        System.out.println("Welcome to the Black Jack");
        while (true) {
            System.out.println("You have " + money + "dollars");
            do {
                System.out.print("How many dollars do you want to bet?  (Enter 0 to end.)");
                bet = scanner.nextInt();
                if (bet < 0 || bet > money) {
                    System.out.println("betting money must be between 0 to " + money);
                }
            } while (bet < 0 || bet > money);
            if (bet == 0) {
            break;
            }
            userWins = playBlackjack();
            if(userWins.equals(GameResult.WIN)){
                money+=bet;
            }
            else if(userWins.equals(GameResult.LOSE)){
                money-=bet;
            }
            else {
                System.out.println("Draw!!");
            }
            if(money == 0){
                System.out.println("\"Looks like you've are out of money!\"");
                break;
            }
        }
        System.out.println("You leave with $"+money);
    }

    private GameResult playBlackjack() {
        return GameResult.WIN;
    }

}
