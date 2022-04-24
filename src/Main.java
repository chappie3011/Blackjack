import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // create and shuffle deck
        Deck playDeck = new Deck();
        playDeck.createDeck();


        // create player and dealer
        Player player1 = new Player();
        Player dealer = new Player();

        // initialize Scanner
        Scanner sc = new Scanner(System.in);

        // initialize bet value to 0 and variable for game actions
        double b = 0.00;
        int myChoice = 0;
        int checker = 0;


        // game control loop
        while (player1.getBetVal() > 0) {

            // initialize the game
            // shuffle deck, decide bet amount, give player and dealer two cards apiece

            playDeck.shuffle();
            player1.getHand().addCardToHand(playDeck.getCard(0));
            playDeck.removeCardFromDeck(0);
            player1.getHand().addCardToHand(playDeck.getCard(0));
            playDeck.removeCardFromDeck(0);
            dealer.getHand().addCardToHand(playDeck.getCard(0));
            playDeck.removeCardFromDeck(0);
            dealer.getHand().addCardToHand(playDeck.getCard(0));
            playDeck.removeCardFromDeck(0);


            System.out.println("Your cards are: " +player1.toString());
            System.out.println("They are worth: "+player1.getHand().handVal());
            System.out.println("One of the dealer's cards is: "+dealer.getHand().dealerToString());
            System.out.println("You currently have " + player1.getBetVal() + ", how much would you like to bet?");
            b = sc.nextDouble();

            while (true) {
                while(dealer.getHand().handVal() < 15) {
                    dealer.getHand().addCardToHand(playDeck.getCard(0));
                    playDeck.removeCardFromDeck(0);
                }
                if(dealer.getHand().handVal() > 21) {
                    System.out.println("Dealer busted! Their hand was worth " + dealer.getHand().handVal() +". You win!");
                    player1.betWin(b);
                    System.out.println("You now have: " +player1.getBetVal());
                    System.out.println("-------------------NEW ROUND-------------------------");
                    for(Card card : player1.getHand().getCards()) {
                        playDeck.addCardToDeck(player1.getHand().getTopCard());
                    }
                    player1.getHand().getCards().clear();
                    dealer.getHand().getCards().clear();
                    break;
                }
                System.out.println("Would you like to hit (1), stand (2), double down (3), or pause (4)? Note: You can only double down immediately after your first two cards have been dealt");
                myChoice = sc.nextInt();
                if (myChoice == 1) {
                    checker = 0;
                    player1.getHand().addCardToHand(playDeck.getCard(0));
                    playDeck.removeCardFromDeck(0);
                    if (player1.getHand().handVal() > 21) {
                        System.out.println("You busted!");
                        System.out.println("Your hand was worth: " + player1.getHand().handVal());
                        player1.betLoss(b);
                        System.out.println("You now have: " +player1.getBetVal());
                        System.out.println("-------------------NEW ROUND-------------------------");
                        for(Card card : player1.getHand().getCards()) {
                            playDeck.addCardToDeck(player1.getHand().getTopCard());
                        }
                        player1.getHand().getCards().clear();
                        dealer.getHand().getCards().clear();
                        break;
                    }
                    System.out.println("Your cards are: " +player1.toString());
                    System.out.println("They are worth: "+player1.getHand().handVal());
                }
                else if (myChoice == 2) {
                    checker = 0;
                    if(player1.getHand().handVal() > dealer.getHand().handVal()) {
                        System.out.println("You win!");
                        System.out.println("Your hand was worth " +player1.getHand().handVal()+ " while the dealer's was worth " +dealer.getHand().handVal());
                        player1.betWin(b);
                        System.out.println("You now have "+player1.getBetVal());
                        System.out.println("-------------------NEW ROUND-------------------------");
                        for(Card card : player1.getHand().getCards()) {
                            playDeck.addCardToDeck(player1.getHand().getTopCard());
                        }
                        player1.getHand().getCards().clear();
                        dealer.getHand().getCards().clear();
                        break;
                    }
                    else if(player1.getHand().handVal() < dealer.getHand().handVal()) {
                        System.out.println("You lose!");
                        System.out.println("Your hand was worth " +player1.getHand().handVal()+ " while the dealer's was worth " +dealer.getHand().handVal());
                        player1.betLoss(b);
                        System.out.println("You now have "+player1.getBetVal());
                        System.out.println("-------------------NEW ROUND-------------------------");
                        for(Card card : player1.getHand().getCards()) {
                            playDeck.addCardToDeck(player1.getHand().getTopCard());
                        }
                        player1.getHand().getCards().clear();
                        dealer.getHand().getCards().clear();
                        break;
                    }
                    else if (player1.getHand().handVal() == dealer.getHand().handVal()) {
                        System.out.println("Tie!");
                        System.out.println("Your hand was worth " +player1.getHand().handVal()+ " while the dealer's was worth " +dealer.getHand().handVal());
                        System.out.println("You now have "+player1.getBetVal());
                        System.out.println("-------------------NEW ROUND-------------------------");
                        for(Card card : player1.getHand().getCards()) {
                            playDeck.addCardToDeck(player1.getHand().getTopCard());
                        }
                        player1.getHand().getCards().clear();
                        dealer.getHand().getCards().clear();
                        break;
                    }
                }
                else if(myChoice == 3 && checker == 0) {
                    System.out.println("How much % would you like to increase your bet by?");
                    int increase = sc.nextInt();
                    b = b+(b*0.01*increase);
                    System.out.println("Your new bet is " + b);

                }

            }
        }
        System.out.println("Game over!");
    }
}