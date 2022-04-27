

public class Player {
    private double betVal = 100.00;
    private Hand hand;

    // constructor
    public Player() {
        hand = new Hand();
    }

    // subtracts money from player's account
    public void betLoss(double b1) {
        betVal -= b1;
    }

    // adds money to player's account
    public void betWin(double b1) {
        betVal += b1;
    }

    // returns value that player bet
    public double getBetVal() {
        return betVal;
    }

    // sets value of bet
    public void setBetVal(double betVal) {
        this.betVal = betVal;
    }

    // returns cards in hand
    public Hand getHand() {
        return hand;
    }

    // sets hand
    public void setHand(Hand hand) {
        this.hand = hand;
    }

    @Override
    public String toString() {
        return ""+hand;
    }






}
