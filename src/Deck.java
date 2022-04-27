import java.util.ArrayList;
import java.util.Collections;


public class Deck {
    private ArrayList<Card> cards;

    // constructor
    public Deck() {
        this.cards = new ArrayList<Card>(0);
    }

    // creates the deck
    public void createDeck() {
        for (Suit cardSuit : Suit.values()) {
            for (Value cardVal : Value.values()) {
                this.cards.add(new Card(cardSuit, cardVal));
            }
        }
    }

    // shuffles the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // returns card
    public Card getCard(int i) {
        return cards.get(i);
    }

    // removes card from deck
    public void removeCardFromDeck(int i) {
        cards.remove(i);
    }

    // adds card to deck
    public void addCardToDeck(Card newCard) {
        cards.add(newCard);
    }

}
