// Class 2: Items
import java.util.*;

public class items {
    String Name;
    int Cost;
    int perChange;
    int stocksAvail;

    //constructor
    items(String Name, int Cost, int perChange, int stocksAvail){
        this.Name = Name;
        this.Cost = Cost;
        this.perChange = perChange;
        this.stocksAvail = stocksAvail;
    }

    //so i can subtract the cost of specific instances from the players money
    public int getCost(){
        return Cost;
    }

    //randomly picks for each stock to either go up or down by a set percent
    public void reprice(){
        Random random = new Random();
        int randomNumber = random.nextInt(2) + 1;
        if (randomNumber == 1) {
            this.Cost = this.Cost - ((this.Cost * this.perChange)/100);
        } 
        if (randomNumber == 2) {
            this.Cost = (this.Cost + (this.Cost * this.perChange / 100));
        }
    }
}

// Subclass: StableStock


// New Subclass: VolatileStock
