package SuperStoreSaver1000;

import java.util.*;

public class VolatileStock extends items {
    VolatileStock(String Name, int Cost, int perChange, int stocksAvail) {
        super(Name, Cost, perChange, stocksAvail);
    }

    // Override the method reprice to change the price MORE 
    @Override
    public void reprice() {
        Random random = new Random();
        int randomNumber = random.nextInt(2) + 1;
        if (randomNumber == 1) {
            this.Cost = this.Cost - ((this.Cost * this.perChange) / 50);
        }
        if (randomNumber == 2) {
            this.Cost = (this.Cost + (this.Cost * this.perChange / 50));
        }
    }
}