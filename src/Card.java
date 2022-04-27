/**
 * @Author Ishan Shukla
 *
 */
public class Card {
    private Suit suit;
    private Value value;

    // constructor
    public Card(Suit s, Value v) {
        suit = s;
        value = v;
    }

    // prints out card, ex: ACE OF SPADES
    public String toString() {
        return this.value.toString()  + " of " + this.suit.toString();
    }

    // returns suit of card
    public Suit getSuit() {
        return this.suit;
    }

    // sets value of suit
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    // returns value of card
    public Value getValue() {
        return this.value;
    }

    // sets value of card
    public void setValue(Value value) {
        this.value = value;
    }
}
