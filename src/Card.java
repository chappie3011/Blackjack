public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit s, Value v) {
        suit = s;
        value = v;
    }

    public String toString() {
        return this.value.toString()  + " of " + this.suit.toString();
    }


    public Suit getSuit() {
        return this.suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Value getValue() {
        return this.value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
