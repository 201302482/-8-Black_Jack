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
                System.out.println("How many dollars do you want to bet?  (Enter 0 to end.)");
                bet = scanner.nextInt();
                scanner.nextLine();
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
        Deck deck = new Deck();
        Player player = new Player();
        Player dealer = new Player();

        player.addCard(deck.dealCard());
        player.addCard(deck.dealCard());

        dealer.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());

        if (dealer.getBlackjackRank() == 21) {
            System.out.println("Dealer has the " + dealer.getCard(0)
                    + " and the " + dealer.getCard(1) + ".");
            System.out.println("User has the " + player.getCard(0)
                    + " and the " + player.getCard(1) + ".");
            System.out.println();
            System.out.println("Dealer has Blackjack.  Dealer wins.");
            return GameResult.LOSE;
        }

        if (player.getBlackjackRank() == 21) {
            System.out.println("Dealer has the " + dealer.getCard(0)
                    + " and the " + dealer.getCard(1) + ".");
            System.out.println("User has the " + player.getCard(0)
                    + " and the " + player.getCard(1) + ".");
            System.out.println();
            System.out.println("You have Blackjack.  You win.");
            return GameResult.WIN;
        }

        while(true) {
            System.out.print("Your cards are:");
            for ( int i = 0; i < player.getCardCount(); i++ )
                System.out.print("    " + player.getCard(i));
            System.out.println();
            System.out.println("Your total is " + player.getBlackjackRank());
            System.out.println("Dealer is showing the " + dealer.getCard(0));

            System.out.print("Hit (H) or Stand (S)? ");
            char userAction;
            do {
                userAction = Character.toUpperCase(scanner.nextLine().charAt(0));
                System.out.println("sfsfs");
                if (userAction != 'H' && userAction != 'S')
                    System.out.println("Please respond H or S:  ");
            } while (userAction != 'H' && userAction != 'S');

            if (userAction == 'S') {
                break;
            }
            else {
                Card newCard = deck.dealCard();
                player.addCard(newCard);
                System.out.println("User hits.");
                System.out.println("Your card is the " + newCard);
                System.out.println("Your total is now " + player.getBlackjackRank());
                if (player.getBlackjackRank() > 21) {
                    System.out.println("You busted by going over 21.  You lose.");
                    System.out.println("Dealer's other card was the "
                            + dealer.getCard(1));
                    return GameResult.LOSE;
                }
            }
        }
        System.out.println("User stands.");
        System.out.print("Dealer's cards are");
        System.out.print("    " + dealer.getCard(0));
        System.out.print("    " + dealer.getCard(1));
        System.out.println();
        while (dealer.getBlackjackRank() <= 16) {
            Card newCard = deck.dealCard();
            System.out.println("Dealer hits and gets the " + newCard);
            dealer.addCard(newCard);
            if (dealer.getBlackjackRank() > 21) {
                System.out.println("Dealer busted by going over 21.  You win.");
                return GameResult.WIN;
            }
        }
        System.out.println("Dealer's total is " + dealer.getBlackjackRank());

        if (dealer.getBlackjackRank() == player.getBlackjackRank()) {
            return GameResult.DRAW;
        }
        else if (dealer.getBlackjackRank() > player.getBlackjackRank()) {
            System.out.println("Dealer wins, " + dealer.getBlackjackRank()
                    + " points to " + player.getBlackjackRank() + ".");
            return GameResult.LOSE;
        }
        else {
            System.out.println("You win, " + player.getBlackjackRank()
                    + " points to " + dealer.getBlackjackRank() + ".");
            return GameResult.WIN;
        }
    }

}
