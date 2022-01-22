import java.util.ArrayList;
import java.util.HashMap;


public class Hand {
    private ArrayList<Card> cards;

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setHand(ArrayList<Card> cards) {
        this.cards = cards;
    }


    public Hand() {
        cards = new ArrayList<Card>(0);
    }

    // TODO: remove later
    public void addCardToHand(Card c){
        cards.add(c);

    }

    public String toString() {
        String cardList = "";
        for (Card card : this.cards) {
            cardList += "\n"  + card.toString();
        }
        return cardList;
    }

    public Card dealerToString() {
        Card dealerCard = this.cards.get(0);
        return dealerCard;

    }

    // TODO: move to Card class
    public int handVal() {
        HashMap<Value, Integer> cardValues= new HashMap<Value, Integer>();
        cardValues.put(Value.ACE, 1);
        cardValues.put(Value.TWO, 2);
        cardValues.put(Value.THREE, 3);
        cardValues.put(Value.FOUR, 4);
        cardValues.put(Value.FIVE, 5);
        cardValues.put(Value.SIX, 6);
        cardValues.put(Value.SEVEN, 7);
        cardValues.put(Value.EIGHT, 8);
        cardValues.put(Value.NINE, 9);
        cardValues.put(Value.TEN, 10);
        cardValues.put(Value.JACK, 10);
        cardValues.put(Value.QUEEN, 10);
        cardValues.put(Value.KING, 10);



        int cardsValue = 0;
        for (Card card : cards) {
            if(card.getValue() == Value.ACE) {
                cardsValue += cardValues.get(Value.ACE);
            }
            else if(card.getValue() == Value.TWO) {
                cardsValue += cardValues.get(Value.TWO);
            }
            else if(card.getValue() == Value.THREE) {
                cardsValue += cardValues.get(Value.THREE);
            }
            else if(card.getValue() == Value.FOUR) {
                cardsValue += cardValues.get(Value.FOUR);
            }
            else if(card.getValue() == Value.FIVE) {
                cardsValue += cardValues.get(Value.FIVE);
            }
            else if(card.getValue() == Value.SIX) {
                cardsValue += cardValues.get(Value.SIX);
            }
            else if(card.getValue() == Value.SEVEN) {
                cardsValue += cardValues.get(Value.SEVEN);
            }
            else if(card.getValue() == Value.EIGHT) {
                cardsValue += cardValues.get(Value.EIGHT);
            }
            else if(card.getValue() == Value.NINE) {
                cardsValue += cardValues.get(Value.NINE);
            }
            else if(card.getValue() == Value.TEN) {
                cardsValue += cardValues.get(Value.TEN);
            }
            else if(card.getValue() == Value.JACK) {
                cardsValue += cardValues.get(Value.JACK);
            }
            else if(card.getValue() == Value.QUEEN) {
                cardsValue += cardValues.get(Value.QUEEN);
            }
            else if(card.getValue() == Value.KING) {
                cardsValue += cardValues.get(Value.KING);
            }
        }
        return cardsValue;
    }
}
