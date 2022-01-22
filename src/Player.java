public class Player {
    private double betVal = 100.00;
    private Hand hand;

    public Player() {
        hand = new Hand();
    }

    public void betLoss(double b1) {
        betVal -= b1;
    }

    public void betWin(double b1) {

        betVal += b1;
    }

    public double getBetVal() {
        return betVal;
    }

    public void setBetVal(double betVal) {
        this.betVal = betVal;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    @Override
    public String toString() {
        return ""+hand;
    }

    //    public void reset(Deck mainDeck) {
//
//        int deckSize = this.deck.size();
//
//        for (int i = 0; i < deckSize; i++) {
//            mainDeck.addCard(this.getCard(i));
//        }
//
//        for (int i = 0; i < deckSize; i++) {
//            this.removeCard(0);
//        }
//    }
    // TODO: remove later
//    public void resetHand(Deck goingTo) {
//        for(int i = 0; i < hand.getHand().size(); i++) {
//            goingTo.addCard(hand.getCard(i));
//        }
//    }



}
