import java.util.ArrayList;
import java.util.Collections;


public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>(0);
    }

    public void createDeck() {
        for (Suit cardSuit : Suit.values()) {
            for (Value cardVal : Value.values()) {
                this.cards.add(new Card(cardSuit, cardVal));
            }
        }
    }
    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card getCard(int i) {
        return cards.get(i);
    }

    public void removeCardFromDeck(int i) {
        cards.remove(i);
    }

    public void addCardToDeck(Card newCard) {
        cards.add(newCard);
    }

}
