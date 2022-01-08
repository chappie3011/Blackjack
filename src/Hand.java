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

    public Card dealerToString() {
        Card dealerCard = this.hand.get(0);
        return dealerCard;

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

}
