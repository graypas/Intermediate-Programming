package New1;

import java.io.*;
import java.util.*;
import SuperStoreSaver1000.*;
import Guessatron3000.*;


public class Games {
    static String[] gameChoices = { "NumberGuessGame", "SuperStore" };
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        HashMap<Game, Integer> gameCounts = new HashMap<Game, Integer>();
        // writes highscores
        File f = new File("Highscore.csv");
        while (true) {
            System.out.println("Which game would you like to play?");
            printGameChoices();
            Game g = getGameChoice();
            System.out.println("You're playing " + g.getGameName());
            g.play();
            g.writeHighScore(f, null);
            // add one to game counts or add it to the hashmap
            if (gameCounts.containsKey(g)) {
                gameCounts.put(g, gameCounts.get(g) + 1);
            } else {
                gameCounts.put(g, 1);
            }
        }
    }

    public static void printGameChoices() {
        int n = 1;
        for (String s : gameChoices) {
            System.out.println("[" + (n++) + "]: " + s);
        }
    }

    /*
     * Takes in user input for printing out all games in
     */
    public static Game getGameChoice() {
        int choice = ErrorCheck.getInt(sc);
        // for it to be numbered, we can't use hashmaps.
        while (choice < 1 || choice > gameChoices.length) {
            System.out.println("We don't have this number. Try again.");
            choice = ErrorCheck.getInt(sc);
        }

        // valid game choice
        String gameString = gameChoices[choice - 1];
        if (gameString.equals("NumberGuessGame")) {
            return new NumberGuessGame();
    }
        if (gameString.equals("SuperStore")) {
            return new SuperStore();
        } else {
            return null;
        }

    }
}

class ErrorCheck {

    public static int getInt(Scanner sc) {
        if (sc.hasNextInt()) {
            return sc.nextInt();
        } else {
            System.out.println("This is not a number. Discarding this input");
            sc.next();
            return getInt(sc);
        }
    }
}
