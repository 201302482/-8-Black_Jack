package com.hw.team8.blackjack;

import lombok.Data;

import java.util.Scanner;

/**
 * Created by com on 2017-06-08.
 */
@Data
public class Game {
    Player player, dealer;
    Scanner scanner;
    int playerMoney, betMoney;
    GameResult userWins;
    CardEvaluator evaluator;

    public Game(){
        player = new Player(new PlayerHand());
        dealer = new Player(new PlayerHand());
        scanner = new Scanner(System.in);
        evaluator = new CardEvaluator();
        playerMoney = 100;
    }

    public void start() {
        System.out.println("Welcome to the Black Jack");
        while (true) {
            System.out.println("You have " + playerMoney + " dollars");
            getBettingMoneyFromUser();
            if (betting_calculate(betMoney)) break;
        }
        System.out.println("You leave with $"+ playerMoney);
    }

    public void getBettingMoneyFromUser() {
        do {
            System.out.println("How many dollars do you want to betMoney?  (Enter 0 to end.)");
            betMoney = scanner.nextInt();
            scanner.nextLine();
            if (betMoney < 0 || betMoney > playerMoney) {
                System.out.println("betting playerMoney must be between 0 to " + playerMoney);
            }
        } while (betMoney < 0 || betMoney > playerMoney);
    }

    public boolean betting_calculate(int bet) {
        if (bet == 0) {
            return true;
        }
        userWins = playBlackjack();
        if(userWins.equals(GameResult.WIN)){
            playerMoney +=bet;
        }
        else if(userWins.equals(GameResult.LOSE)){
            playerMoney -=bet;
        }
        else {
            System.out.println("Draw!!");
        }
        if(playerMoney == 0){
            System.out.println("\"Looks like you've are out of playerMoney!\"");
            return true;
        }
        return false;
    }

    private GameResult playBlackjack() {
        Deck deck = new Deck();

        GameResult gameResult;

        player.getPlayerHand().addCard(deck.dealCard());
        player.getPlayerHand().addCard(deck.dealCard());

        dealer.getPlayerHand().addCard(deck.dealCard());
        dealer.getPlayerHand().addCard(deck.dealCard());

        gameResult = isBlackJack();
        if(gameResult != null){
            return gameResult;
        }

        while(true) {
            System.out.print("Your cards are:");
            for ( int i = 0; i < player.getPlayerHand().getCardCount(); i++ )
                System.out.print("    " + player.getPlayerHand().getCard(i));
            System.out.println();
            System.out.println("Your total is " + evaluator.getBlackjackRank(player));
            System.out.println("Dealer is showing the " + dealer.getPlayerHand().getCard(0));

            char userAction = getUserAction();
            if (userAction == 'S') {
                break;
            }
            else {
                Card newCard = deck.dealCard();
                player.getPlayerHand().addCard(newCard);
                System.out.println("User hits.");
                System.out.println("Your card is the " + newCard);
                System.out.println("Your total is now " + evaluator.getBlackjackRank(player));
                if (evaluator.getBlackjackRank(player) > 21) {
                    System.out.println("You busted by going over 21.  You lose.");
                    System.out.println("Dealer's other card was the "
                            + dealer.getPlayerHand().getCard(1));
                    return GameResult.LOSE;
                }
            }
        }
        System.out.println("User stands.");
        System.out.print("Dealer's cards are");
        System.out.print("    " + dealer.getPlayerHand().getCard(0));
        System.out.print("    " + dealer.getPlayerHand().getCard(1));
        System.out.println();
        while (evaluator.getBlackjackRank(dealer) <= 16) {
            Card newCard = deck.dealCard();
            System.out.println("Dealer hits and gets the " + newCard);
            dealer.getPlayerHand().addCard(newCard);
            if (evaluator.getBlackjackRank(dealer) > 21) {
                System.out.println("Dealer busted by going over 21.  You win.");
                return GameResult.WIN;
            }
        }
        System.out.println("Dealer's total is " + evaluator.getBlackjackRank(dealer));

        return getGameResult();
    }

    public GameResult getGameResult() {
        if (evaluator.getBlackjackRank(dealer) == evaluator.getBlackjackRank(player)) {
            return GameResult.DRAW;
        }
        else if (evaluator.getBlackjackRank(dealer) > evaluator.getBlackjackRank(player)) {
            System.out.println("Dealer wins, " + evaluator.getBlackjackRank(dealer)
                    + " points to " + evaluator.getBlackjackRank(player) + ".");
            return GameResult.LOSE;
        }
        else {
            System.out.println("You win, " + evaluator.getBlackjackRank(player)
                    + " points to " + evaluator.getBlackjackRank(dealer) + ".");
            return GameResult.WIN;
        }
    }
    public GameResult isBlackJack(){
        System.out.println("Dealer has the " + dealer.getPlayerHand().getCard(0)
                + " and the " + dealer.getPlayerHand().getCard(1) + ".");
        System.out.println("User has the " + player.getPlayerHand().getCard(0)
                + " and the " + player.getPlayerHand().getCard(1) + ".");
        System.out.println();
        if(evaluator.getBlackjackRank(player) == 21){
            print_TwoCards(player, dealer);
            System.out.println("Dealer has Blackjack.  Dealer wins.");
            return GameResult.LOSE;
        }
        else if (evaluator.getBlackjackRank(player) == 21) {
            print_TwoCards(player, dealer);
            System.out.println("You have Blackjack.  You win.");
            return GameResult.WIN;
        }
        return null;
    }

    public void print_TwoCards(Player player, Player dealer) {
        System.out.println("Dealer has the " + dealer.getPlayerHand().getCard(0)
                + " and the " + dealer.getPlayerHand().getCard(1) + ".");
        System.out.println("User has the " + player.getPlayerHand().getCard(0)
                + " and the " + player.getPlayerHand().getCard(1) + ".");
        System.out.println();
    }

    public char getUserAction() {
        System.out.print("Hit (H) or Stand (S)? ");
        char userAction;
        do {
            userAction = Character.toUpperCase(scanner.nextLine().charAt(0));
            if (userAction != 'H' && userAction != 'S')
                System.out.println("Please respond H or S:  ");
        } while (userAction != 'H' && userAction != 'S');
        return userAction;
    }
}
