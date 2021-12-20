import java.util.ArrayList;
import java.util.Scanner;

public class Hand extends Deck{

    public ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<Card>(0);
    }

    public void drawCard(Deck d){
        hand.add(d.getCard(0));
        d.removeCard(0);
    }

    public String toString() {
        String cardList = "";
        for (Card card : this.hand) {
            cardList += "\n"  + card.toString();
        }
        return cardList;
    }
    public int handVal() {
        int cardsValue = 0;
        for(Card card : hand) {
            switch (card.getValue()) {
                case ACE -> {
                    cardsValue += 1;
                    break;
                }
                case TWO -> {
                    cardsValue += 2;
                    break;
                }
                case THREE -> {
                    cardsValue += 3;
                    break;
                }
                case FOUR -> {
                    cardsValue += 4;
                    break;
                }
                case FIVE -> {
                    cardsValue += 5;
                    break;
                }
                case SIX -> {
                    cardsValue += 6;
                    break;
                }
                case SEVEN -> {
                    cardsValue += 7;
                    break;
                }
                case EIGHT -> {
                    cardsValue += 8;
                    break;
                }
                case NINE -> {
                    cardsValue += 9;
                    break;
                }
                case TEN, JACK, QUEEN, KING -> {
                    cardsValue += 10;
                    break;
                }
            }
        }
        return cardsValue;
    }








//    public int handVal;
//    public int dealerVal;
//    public ArrayList<Card> dealerHand;
//
//
//    public Hand(Deck deck) {
//        hand = new ArrayList<Card>(0);
//
//        dealerVal = 0;
//        dealerHand = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
//            hand.add(deck.drawCard());
//            dealerHand.add(deck.drawCard());
//        }
//    }
//
//    public void play(Deck deck) {
//        while (true) {
//            Scanner hitter = new Scanner(System.in);
//            System.out.println("Would you like to (h)it or (s)tand?");
//            String choice = hitter.nextLine();
//            if(choice.equals("h")) {
//                hand.add(deck.drawCard());
//                for (int i = 0; i < hand.size(); i++) {
//       //             handVal += hand.get(i).getNums();
//                }
//                System.out.println("Your hand is worth "+getHandVal());
//            }
//            else if(choice.equals("s")) {
//                System.out.println("Your hand is worth "+getHandVal());
//                System.out.println("The dealer's is worth "+getDealerVal());
//                if(getHandVal() > getDealerVal()) {
//                    System.out.println("You win!");
//                    for(int i = 0; i < hand.size(); i++) {
//                        hand.remove(i);
//                    }
//                    break;
//                }
//                else {
//                    System.out.println("You lose!");
//                    for(int i = 0; i < hand.size(); i++) {
//                        hand.remove(i);
//                    }
//                    break;
//                }
//            }
//
//        }
//
//    }
//
//    public int getHandVal() {
//        return handVal;
//    }
//    public int getDealerVal() {
//        return dealerVal;
//    }

}
