import java.util.ArrayList;
public class Player {
    int Money;
    ArrayList<items> stockList = new ArrayList<items>();

    //constructor
    Player(int Money, ArrayList<items> stockList){
        this.Money = Money;
        this.stockList = stockList;
    }
}
