import java.util.*;

public class StableStock extends items {
    StableStock(String Name, int Cost, int perChange, int stocksAvail) {
        super(Name, Cost, perChange, stocksAvail);
    }

    // Override the method reprice to change the price LESS 
    @Override
    public void reprice() {
        Random random = new Random();
        int randomNumber = random.nextInt(2) + 1;
        if (randomNumber == 1) {
            this.Cost = this.Cost - ((this.Cost * this.perChange) / 200);
        }
        if (randomNumber == 2) {
            this.Cost = (this.Cost + (this.Cost * this.perChange / 200));
        }
    }
}