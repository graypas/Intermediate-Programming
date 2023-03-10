import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class App {

    public static void main(String[] args) {

        // Create a new Scanner object to read input from the user

        Scanner input = new Scanner(System.in);

        // Initialize the minimum and maximum values for the range of the game

        int min = 0;
        int max = 0;

        // Loop until the user enters a valid range

        while (min >= max) {
            System.out.println("Enter the range of the game: ");

            // Check that the first input is an integer

            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter two integers separated by a space.");
                input.nextLine();
            }
            min = input.nextInt();

            // Check that the second input is an integer

            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter two integers separated by a space.");
                input.nextLine();
            }
            max = input.nextInt();

            // Check that the first number is less than the second number

            if (min >= max) {
                System.out.println(
                        "Invalid range. Please enter a valid range where the first number is less than the second.");
            }
        }
        input.nextLine();

        // Create a new Random object to generate the number to guess

        Random rand = new Random();

        // Generate a random number between min and max

        int number = rand.nextInt(max - min + 1) + min;

        // Create an ArrayList to store previous guesses

        ArrayList<Integer> previousGuesses = new ArrayList<Integer>();

        System.out.println("I'm thinking of a number between " + min + " and " + max + ". Can you guess it?");

        // Initialize guess count at user guess

        int guess = -1;
        int guessCount = 0;

        // Loop until the user guesses the correct number

        while (guess != number) {
            System.out.print("Enter your guess: ");

            // Check that the input is an integer

            if (input.hasNextInt()) {
                guess = input.nextInt();

                // Check if the user has already guessed this number

                if (previousGuesses.contains(guess)) {
                    System.out.println("You already tried this number. This guess isn't counted.");
                    continue;
                }
                previousGuesses.add(guess);
                guessCount++;

                // Check if the guess is within the valid range

                if (guess < min || guess > max) {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                    continue;
                }

                // Check if the guess is too low or too high

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

        //Print the amount of guesses the user did as well as end

        System.out.println("You guessed the number in " + guessCount + " attempts.");
        input.close();
    }
}