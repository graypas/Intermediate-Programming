package SuperStoreSaver1000;

import java.util.*;

public class Player {
    int Money;
    ArrayList<items> stockList = new ArrayList<items>();

    Player(int Money, ArrayList<items> stockList){
        this.Money = Money;
        this.stockList = stockList;
    }
}
