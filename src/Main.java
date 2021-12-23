import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Deck playDeck = new Deck();
        playDeck.createDeck();
        playDeck.shuffle();


        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        playerHand.drawCard(playDeck);
        playerHand.drawCard(playDeck);
        dealerHand.drawCard(playDeck);
        dealerHand.drawCard(playDeck);

        while (true) {

            System.out.println("Your hand is worth " + playerHand.handVal());
            System.out.println("The cards in your hand are: " + playerHand.toString());
            Scanner sc = new Scanner(System.in);
            System.out.println("Would you like to (h)it or (s)tand?");
            System.out.println("--------------------");
            while (dealerHand.handVal() < 17) {
                dealerHand.drawCard(playDeck);
            }
            if (dealerHand.handVal() > 21) {
                System.out.println("Dealer busted! You win!");
                System.out.println("The dealer's hand was worth " + dealerHand.handVal());
                System.out.println("The dealer's cards were " + dealerHand.toString());
            }
            String choice = sc.nextLine();
            if (choice.equals("h")) {
                playerHand.drawCard(playDeck);

                if (playerHand.handVal() > 21) {
                    System.out.println("You busted! You lose!");
                    System.out.println("Your hand is worth " + playerHand.handVal());
                    System.out.println("The cards in your hand were " + playerHand.toString());
                    break;
                }

            }
            else if (choice.equals("s")) {
                System.out.println("Your hand is worth " + playerHand.handVal() + " and the dealer's is worth " + dealerHand.handVal());
                if (playerHand.handVal() > dealerHand.handVal()) {
                    System.out.println("You win!");
                    break;
                }
                else {
                    System.out.println("You lose!");
                    break;
                }
            }

        }



    }
}
