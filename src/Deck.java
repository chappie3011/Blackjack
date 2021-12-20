import java.util.ArrayList;
import java.util.Collections;


public class Deck {

    public ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<Card>(0);
    }

    public void createDeck() {
        for (Suit cardSuit : Suit.values()) {
            for (Value cardVal : Value.values()) {
                this.deck.add(new Card(cardSuit, cardVal));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }




    public Card getCard(int i) {
        return deck.get(i);
    }

    public void removeCard(int i) {
        deck.remove(i);
    }

    public void addCard(Card newCard) {
        deck.add(newCard);
    }






}
