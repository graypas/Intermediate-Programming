package Guessatron3000;

import java.io.*;
import java.util.*;
import New1.*;

public class NumberGuessGame implements Game{
    public static Settings game1; 
    static int min = 1;
    static int max;
    static int number;
    static int guess;
    static int guessCount = 0;

    @Override
    public String getGameName() {
        String Name = "The Number Guess Game";
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
        //     FileWriter fileWriter = new FileWriter(f, true); // true indicates append mode
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
        } 
        catch (NumberFormatException e) {
            System.out.println("Not an integer, try again.");
            return false;
        }
    }
    public void play() {

        Scanner input = new Scanner(System.in);

            System.out.println("Input one of these numbers to select the difficulty of this game");
            System.out.println("1 : Minimum 1 Maximum 10\n2 : Minimum 1 Maximum 50\n3 : Minimum 1 Maximum 100");

            while(true){
                String diffInp = input.nextLine();
                boolean roar = validInt(diffInp);

                if (roar == false || !diffInp.equals("1") && !diffInp.equals("2") && !diffInp.equals("3")){
                    System.out.println("input an integer or a number between 1 and 3");
                    continue;
                }
                else{
                    game1.diffLvl = Integer.parseInt(diffInp);
                    break;
                }    
            }
            
            if (game1.diffLvl == 1){
                max = 10;
            }
            if (game1.diffLvl == 2){
                max = 50;
            }
            if (game1.diffLvl == 3){
                max = 100;
            }

            Random rand = new Random();
            number = rand.nextInt(max - min + 1) + min;

            ArrayList<Integer> bark1 = new ArrayList<Integer>();
            ArrayList<Integer> bark2 = new ArrayList<Integer>();
            ArrayList<Integer> bark3 = new ArrayList<Integer>();

            ArrayList<Integer> previousGuesses = new ArrayList<Integer>();
            System.out.println("I'm thinking of a number between " + min + " and " + max + ". Can you guess it?");

            while (guess != number) {
                System.out.print("Enter your guess: ");

                if (input.hasNextInt()) {
                    guess = input.nextInt();

                    if (previousGuesses.contains(guess)) {
                        System.out.println("You already tried this number. This guess isn't counted.");
                        continue;
                    }
                    previousGuesses.add(guess);
                    guessCount++;

                    if (guess < min || guess > max) {
                        System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                        continue;
                    }

                    if (guess < number) {
                        System.out.println("Your guess is too low.");
                    } else if (guess > number) {
                        System.out.println("Your guess is too high.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                    input.nextLine();
                }
            }

            System.out.println("You guessed the number in " + guessCount + " attempts.");
            Settings.finalScore = Settings.finalScore + guessCount;
            System.out.println("Would you like to play again\n1 : yes\n2 : no");
            while(true){
                String newGame = input.nextLine();
                boolean roar3 = validInt(newGame);

                if (roar3 == false || !newGame.equals("1") && !newGame.equals("2")){
                    System.out.println("input an integer or a number between 1 and 2");
                    continue;
                }

                else if(newGame.equals("2")){
                    System.exit(0);
                    input.close();  
                }

                else{
                    if(game1.diffLvl == 1){
                        bark1.add(Settings.finalScore);
                        System.out.println("Your guesses for the difficulty level 1 are: ");
                        getScore(game1.finalScore);
                        System.out.println(bark1);
                        
                    }
                    else if(game1.diffLvl == 2){
                        bark2.add(game1.finalScore);
                        System.out.println("Your guesses for the difficulty level 2 are: ");
                        getScore(game1.finalScore);
                        System.out.println(bark2);
                        
                    }
                    else if(game1.diffLvl == 3){
                        bark3.add(game1.finalScore);
                        System.out.println("Your guesses for the diffuclty level 3 are: ");
                        getScore(game1.finalScore);
                        System.out.println(bark3);
                    }

                    game1 = new Settings(0, 0);

                    break;
                }       
            }
        }
    }
