import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Deck playDeck = new Deck();
        playDeck.createDeck();
        playDeck.shuffle();


        Player player1 = new Player();
        Player dealer = new Player();

        player1.drawCard(playDeck);
        player1.drawCard(playDeck);
        dealer.drawCard(playDeck);
        dealer.drawCard(playDeck);

        while (true) {

            System.out.println("Your hand is worth " + player1.handVal());
            System.out.println("--------------------");
            System.out.println("The cards in your hand are: " + player1.toString());
            System.out.println("--------------------");
            System.out.println("One of the dealer's cards is " + dealer.dealerToString());
            System.out.println("--------------------");
            Scanner sc = new Scanner(System.in);
            System.out.println("Would you like to (h)it or (s)tand?");
            System.out.println("--------------------");
            while (dealer.handVal() < 15) {
                dealer.drawCard(playDeck);
            }
            if (dealer.handVal() > 21) {
                System.out.println("Dealer busted! You win!");
                System.out.println("--------------------");
                System.out.println("The dealer's hand was worth " + dealer.handVal());
                System.out.println("--------------------");
                System.out.println("The dealer's cards were " + dealer.toString());
            }
            String choice = sc.nextLine();
            if (choice.equals("h")) {
                player1.drawCard(playDeck);

                if (player1.handVal() > 21) {
                    System.out.println("You busted! You lose!");
                    System.out.println("--------------------");
                    System.out.println("Your hand is worth " + player1.handVal());
                    System.out.println("--------------------");
                    System.out.println("The cards in your hand were " + player1.toString());
                    System.out.println("--------------------");
                    break;
                }

            }
            else if (choice.equals("s")) {
                System.out.println("Your hand is worth " + player1.handVal() + " and the dealer's is worth " + dealer.handVal());
                if (player1.handVal() > dealer.handVal()) {
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
