public class Player extends Hand{
    public double betVal = 100.00;
    public Hand hand;

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
}
