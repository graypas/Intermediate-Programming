package SuperStoreSaver1000;

import java.util.*;
import java.io.*;
import New1.*;

public class SuperStore implements Game {
    @Override
    public String getGameName() {
        String Name = "The Super Store";
        return Name;
    }

    @Override
    public String getScore(int score1){
        String score2 = Integer.toString(score1);
        return score2;
    }

    @Override
    public void writeHighScore(File f, String score2){
        // try {
        //     FileWriter fileWriter = new FileWriter(f, true); 
        //     BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        //     bufferedWriter.write(score2);
        //     bufferedWriter.newLine();

        //     bufferedWriter.close();
        // } catch (IOException e) {
        // }
    }       

    public static boolean validInt(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Not an integer, try again.");
            return false;
        }
    }

    public static int chooseStock(Scanner input) {
        String roar;

        int STchoice = 0;

        while (STchoice < 1 || STchoice > 10) {
            System.out.println("Which stock would you like to buy (1-10)? ");
            roar = input.nextLine();

            if (validInt(roar)) {
                STchoice = Integer.parseInt(roar);
            }

            if (STchoice < 1 || STchoice > 10) {
                System.out.println("Invalid choice. Please enter a number between 1 and 10.");
            }
        }
        return STchoice - 1;
    }

    public static String buyorSell(Scanner input) {

        String roar2;
        String BSchoice;

        System.out.println("Would you like to buy or sell this stock? Please enter either 'b' or 's'.");

        while (true) {
            roar2 = input.nextLine();
            System.out.println(roar2);
            if (roar2.equals("b") || roar2.equals("B") || roar2.equals("s") || roar2.equals("S")) {
                BSchoice = roar2;
                break;
            }

            else {
                System.out.println("Invalid choice. Please enter either 'b' or 's'.");
            }

        }
        return BSchoice;
    }
    @Override
    public void play() {

        int x = 1; 
        int word; 

        int sub; 
        int add; 
        int rc = 0;

        String word2; 

        Boolean blah; 

        ArrayList<items> things = new ArrayList<items>(); 
        ArrayList<items> itemList = new ArrayList<items>(); 

        Player User = new Player(1000, things); 

        Scanner input = new Scanner(System.in);

        int countiewounties = things.size();
        int numbiepumpbies = 0;

        itemList.add(new StableStock("Apple", 55, 10, 1));
        itemList.add(new VolatileStock("Microsoft", 50, 12, 1));
        itemList.add(new StableStock("Netflix", 45, 14, 1));
        itemList.add(new VolatileStock("Disney", 40, 16, 1));
        itemList.add(new StableStock("Toyota", 35, 18, 1));
        itemList.add(new VolatileStock("Mercedes", 30, 20, 1));
        itemList.add(new StableStock("Meta", 25, 22, 1));
        itemList.add(new VolatileStock("Twitter", 20, 24, 1));
        itemList.add(new items("Walmart", 15, 26, 1));
        itemList.add(new items("Amazon", 10, 28, 1));

        while (User.Money > 0) {
            for (items q : itemList) {
                System.out.println(x + ") " + q.Name + " - $" + q.Cost + " - " + q.stocksAvail);
                x++;
            }

            x = 1;

            word = chooseStock(input); 
            word2 = buyorSell(input); 
            

            if (word2.equals("b") || word2.equals("B")) {
                if (User.Money < itemList.get(word).getCost()) {
                    System.out.println("You cannot buy this item.");
                    continue;
                }

                for (items e : itemList) {
                    e.reprice();
                }

                things.add(itemList.get(word)); 
                sub = itemList.get(word).getCost(); 

                User.Money -= sub; 

                itemList.get(word).stocksAvail--; 
                System.out.println(
                        "You bought 1 " + itemList.get(word).Name + " stock.\nThere are now " + itemList.get(word).stocksAvail
                                + " remaining.\nYou now have " + User.Money + " dollars remaining.");
        
                for (items w : things) {
                    numbiepumpbies++;
                    System.out.print(w.Name);
                    if (numbiepumpbies < countiewounties) {
                        System.out.print(", ");
                        }
                    }

                for (items u : itemList) {
                    if (u.stocksAvail > 1) {
                        System.out.println("\n");
                        continue;
                    }
    
                    if(u.stocksAvail == 0){
                        // System.out.println("\n");
                        System.out.println("\nYou purchased an entire company's stocks, you win!!");
                        getScore(rc);
                        System.exit(0);
                    }
                }
            }

            if (word2.equals("s") || word2.equals("S")) {
                blah = (things.contains(itemList.get(word)));
                add = itemList.get(word).getCost();

                if (blah == true) {
                    things.remove(itemList.get(word));

                    itemList.get(word).stocksAvail++;
                    User.Money += add;
                    System.out.println("You sold 1 " + itemList.get(word).Name + " stock.\nThere are now "
                            + itemList.get(word).stocksAvail + " remaining.\nYou now have " + User.Money + " dollars.");
                    rc = rc + 1;
                    
                    for (items r : itemList) {
                        r.reprice();
                    }

                }

                if (blah == false) {
                    System.out.println("You do not own this so you can't sell it. Please pick something else.");
                    continue;
                }
            }
        }

        System.out.println("You ran out of money :(");
    }
}