import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

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

    public static void writeToFile(Player p) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Stats.txt"));
        objectOutputStream.writeObject(p);
    }




}
