import java.util.*;

public class items {
    String Name;
    int Cost;
    int perChange;
    int stocksAvail;

    items(String Name, int Cost, int perChange, int stocksAvail){
        this.Name = Name;
        this.Cost = Cost;
        this.perChange = perChange;
        this.stocksAvail = stocksAvail;
    }

    public int getCost(){
        return Cost;
    }

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
