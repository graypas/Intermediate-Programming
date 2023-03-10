import java.util.*;

public class App {

    // checks if the string can be parsed as an integer
    public static boolean validInt(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Not an integer, try again.");
            return false;
        }
    }

    // Pick a stocks index
    public static int chooseStock(Scanner input) {
        String roar;

        int STchoice = 0;

        // loop until the user picks an integer between 1 and 10
        while (STchoice < 1 || STchoice > 10) {
            System.out.println("Which stock would you like to buy (1-10)? ");
            roar = input.nextLine();

            // checks if the user input is an integer
            if (validInt(roar)) {
                STchoice = Integer.parseInt(roar);
            }

            if (STchoice < 1 || STchoice > 10) {
                System.out.println("Invalid choice. Please enter a number between 1 and 10.");
            }
        }
        // return the index of the stock and subtract 1 to allow the user to pick apple
        return STchoice - 1;
    }

    // asks the user to buy or sell the chosen stock from above
    public static String buyorSell(Scanner input) {

        String roar2;
        String BSchoice;

        System.out.println("Would you like to buy or sell this stock? Please enter either 'b' or 's'.");

        // loop until the user picks a valid option
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
        // return the user's choice as a string
        return BSchoice;
    }

    public static void main(String[] args) throws Exception {

        int x = 1; // used to print the stocks
        int word; // index of the stock
        int sub; // subtracting the cost of a stock from the player's money
        int add; // adding the cost of a stock to the player's money

        String word2; // player's choice to buy or sell

        Boolean blah; // boolean to check whether or not the player owns the stock they are trying to
                      // interact with

        boolean endGame = false; // used to check if the game can end if the player has bought out a company

        ArrayList<items> things = new ArrayList<items>(); // player's list of owned stock
        ArrayList<items> itemList = new ArrayList<items>(); // list of instances of the item class

        Player User = new Player(1000, things); // initialize the player with a 1000 dollars and an empty list of stocks

        Scanner input = new Scanner(System.in);

        // create a list of items name, cost, percent change, and stocks available to
        // buy
        itemList.add(new items("Apple", 55, 10, 50));
        itemList.add(new items("Microsoft", 50, 12, 50));
        itemList.add(new items("Netflix", 45, 14, 55));
        itemList.add(new items("Disney", 40, 16, 55));
        itemList.add(new items("Toyota", 35, 18, 65));
        itemList.add(new items("Mercedes", 30, 20, 65));
        itemList.add(new items("Meta", 25, 22, 70));
        itemList.add(new items("Twitter", 20, 24, 70));
        itemList.add(new items("Walmart", 15, 26, 75));
        itemList.add(new items("Amazon", 10, 28, 75));

        // Loop that displays the list of items and their details
        // dependant on the fact the user still has money
        while (User.Money > 0) {
            for (items q : itemList) {
                System.out.println(x + ") " + q.Name + " - $" + q.Cost + " - " + q.stocksAvail);
                x++;
            }

            x = 1;

            word = chooseStock(input); // Get user input for which item they want to buy or sell
            word2 = buyorSell(input); // Get user input for whether they want to buy or sell the item

            // every time a new round starts it sifts through the amount of available stocks
            // and if any equal 0 the game is won
            for (items u : itemList) {
                if (u.stocksAvail > 0) {
                    endGame = false;
                    break;
                }
                if (u.stocksAvail == 0) {
                    endGame = true;
                    System.out.println("You purchased an entire company's stocks, you win!!");
                    System.exit(0);
                }
            }

            // uses the user input to check if it's a buy or sell
            if (word2.equals("b") || word2.equals("B")) {
                things.add(itemList.get(word)); // adds the stock to the player's list of owned stocks
                sub = itemList.get(word).getCost(); //gets the cost of the stock

                User.Money -= sub; // subtracts the cost of the stock from the user's money

                if (User.Money < itemList.get(word).getCost()) {
                    System.out.println("You cannot buy this item.");
                    continue;
                }

                for (items e : itemList) {
                    e.reprice();
                }

                itemList.get(word).stocksAvail--;
                System.out.println(
                        "You bought " + itemList.get(word).Name + ".\nThere are now " + itemList.get(word).stocksAvail
                                + " remaining.\n You now have " + User.Money + " dollars remaining.");

                for (items w : things) {
                    System.out.print(w.Name + ", ");
                }

                System.out.println("\n");

                continue;
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

                    for (items r : itemList) {
                        r.reprice();
                    }

                    continue;
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