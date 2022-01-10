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
        Scanner sc = new Scanner(System.in);
        double b = 0.00;
        int myChoice = 0;
        int flag = 0;
        while (myChoice == 0) {
            System.out.println("--------------------");
            System.out.println("Your hand is worth " + player1.handVal());
            System.out.println("--------------------");
            System.out.println("The cards in your hand are: " + player1.toString());
            System.out.println("--------------------");
            System.out.println("One of the dealer's cards is " + dealer.dealerToString());
            System.out.println("--------------------");
            if(flag == 0) {
                System.out.println("You currently have " + player1.getBetVal()+", how much would you like to bet?");
                b = sc.nextDouble();
                flag = 1;
            }
            System.out.println("Would you like to hit (1) or stand (2)?");
            System.out.println("--------------------");
            //System.out.println("My choice before" +myChoice);
            myChoice = sc.nextInt();
           // System.out.println("My choice after" +myChoice);
            while (dealer.handVal() < 15) {
                dealer.drawCard(playDeck);
            }
            if (dealer.handVal() > 21) {
                System.out.println("Dealer busted! You win!");
                System.out.println("--------------------");
                System.out.println("The dealer's hand was worth " + dealer.handVal());
                System.out.println("--------------------");
                System.out.println("The dealer's cards were " + dealer.toString());
                System.out.println("--------------------");
                player1.betWin(b);
                System.out.println("You now have "+player1.getBetVal());
            }

            if (myChoice == 1) {
                player1.drawCard(playDeck);
                System.out.println(player1.toString());
                if (player1.handVal() > 21) {
                    System.out.println("You busted! You lose!");
                    System.out.println("--------------------");
                    System.out.println("Your hand is worth " + player1.handVal());
                    System.out.println("--------------------");
                    System.out.println("The cards in your hand were " + player1.toString());
                    System.out.println("--------------------");
                    player1.betLoss(b);
                    System.out.println("You now have "+player1.getBetVal());
                    break;
                }
            }
            else if (myChoice == 2) {
                System.out.println("Your hand is worth " + player1.handVal() + " and the dealer's is worth " + dealer.handVal());
                if (player1.handVal() > dealer.handVal()) {
                    System.out.println("You win!");
                    player1.betWin(b);
                    System.out.println("You now have "+player1.getBetVal());
                    break;
                }
                else {
                    System.out.println("You lose!");
                    player1.betLoss(b);
                    System.out.println("You now have "+player1.getBetVal());
                    break;
                }
            }
            myChoice = 0;
        }
    }
}
