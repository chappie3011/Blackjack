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

        // game control loop
        while (player1.getBetVal() > 0) {

            // initialize the game
            // shuffle deck, decide bet amount, give player and dealer two cards apiece

            playDeck.shuffle();
            System.out.println("You currently have " + player1.getBetVal() + ", how much would you like to bet?");
            b = sc.nextDouble();
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

            while (true) {
                while(dealer.getHand().handVal() < 15) {
                    dealer.getHand().addCardToHand(playDeck.getCard(0));
                    playDeck.removeCardFromDeck(0);
                }
                if(dealer.getHand().handVal() > 21) {
                    System.out.println("Dealer busted! Their hand was worth " + dealer.getHand().handVal() +". You win!");
                    player1.betWin(b);
                    System.out.println("You now have: " +player1.getBetVal());
//                    for(Card card : player1.getHand().getCards()) {
//                        player1.getHand().getCards().remove(0);
//                    }
//                    System.out.println("Checker: "+player1.toString());
//                    break;
                }
                System.out.println("Would you like to hit (1) or stand (2)?");
                myChoice = sc.nextInt();
                if (myChoice == 1) {
                    player1.getHand().addCardToHand(playDeck.getCard(0));
                    playDeck.removeCardFromDeck(0);
                    if (player1.getHand().handVal() > 21) {
                        System.out.println("You busted!");
                        System.out.println("Your hand was worth: " + player1.getHand().handVal());
                        player1.betLoss(b);
                        System.out.println("You now have: " +player1.getBetVal());
//                        for(Card card : player1.getHand().getCards()) {
//                            player1.getHand().getCards().remove(0);
//                        }
//                        System.out.println("Checker: "+player1.toString());
//                        break;
                    }
                    System.out.println("Your cards are: " +player1.toString());
                    System.out.println("They are worth: "+player1.getHand().handVal());
                }
                else if (myChoice == 2) {
                    if(player1.getHand().handVal() > dealer.getHand().handVal()) {
                        System.out.println("You win!");
                        System.out.println("Your hand was worth " +player1.getHand().handVal()+ " while the dealer's was worth " +dealer.getHand().handVal());
                        player1.betWin(b);
                        System.out.println("You now have "+player1.getBetVal());
//                        for(Card card : player1.getHand().getCards()) {
//                            player1.getHand().getCards().remove(0);
//                        }
//                        System.out.println("Checker: "+player1.toString());
//                        break;
                    }
                    else if(player1.getHand().handVal() < dealer.getHand().handVal()) {
                        System.out.println("You lose!");
                        System.out.println("Your hand was worth " +player1.getHand().handVal()+ " while the dealer's was worth " +dealer.getHand().handVal());
                        player1.betLoss(b);
                        System.out.println("You now have "+player1.getBetVal());
//                        for(Card card : player1.getHand().getCards()) {
//                            player1.getHand().getCards().remove(0);
//                        }
//                        System.out.println("Checker: "+player1.toString());
//                        break;
                    }
                }
            }
        }
        System.out.println("Game over!");
    }
}