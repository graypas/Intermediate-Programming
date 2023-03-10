import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) throws Exception {

        // Create Categories
        Category Chinese = new Category("Chinese", "You enjoy Chinese food the most.", 0);
        Category American = new Category("American", "You enjoy American food the most.", 0);
        Category Mexican = new Category("Mexican", "You enjoy Mexican food the most.", 0);
        Category Italian = new Category("Italian", "You enjoy Italian food the most.", 0);
        // Create Questions

        Question q1 = new Question("What snack would you have picked at 12 years old?");
        // Attach Answers to Questions
        q1.possibleAnswers[0] = new Answer("Pizza rolls", Italian);
        q1.possibleAnswers[1] = new Answer("Rice cakes", Chinese);
        q1.possibleAnswers[2] = new Answer("Tacos", Mexican);
        q1.possibleAnswers[3] = new Answer("Tater tots", American);

        Question q2 = new Question("What dessert seems the best to you?");
        q2.possibleAnswers[0] = new Answer("Tiramisu", Italian);
        q2.possibleAnswers[1] = new Answer("Churros", Mexican);
        q2.possibleAnswers[2] = new Answer("Steamed sponge cake", Chinese);
        q2.possibleAnswers[3] = new Answer("Apple pie", American);

        Question q3 = new Question("You're with your friends, what fast food place are you going to?");
        q3.possibleAnswers[0] = new Answer("Dominos", Italian);
        q3.possibleAnswers[1] = new Answer("Taco Bell", Mexican);
        q3.possibleAnswers[2] = new Answer("Panda Express", Chinese);
        q3.possibleAnswers[3] = new Answer("McDonalds", American);

        Question q4 = new Question("Pick an appetizer");
        q4.possibleAnswers[0] = new Answer("Crostini", Italian);
        q4.possibleAnswers[1] = new Answer("Nachos", Mexican);
        q4.possibleAnswers[2] = new Answer("Spring rolls", Chinese);
        q4.possibleAnswers[3] = new Answer("Pigs in a blanket", American);

        Question q5 = new Question("What drink would you order?");
        q5.possibleAnswers[0] = new Answer("Chinotto", Italian);
        q5.possibleAnswers[1] = new Answer("Horchatta", Mexican);
        q5.possibleAnswers[2] = new Answer("Pearl milk tea", Chinese);
        q5.possibleAnswers[3] = new Answer("Snapple", American);

        Scanner thing = new Scanner(System.in);
        Question QuestionCount[] = { q1, q2, q3, q4, q5 };
        Category[] categories = { Italian, Chinese, Mexican, American };
        int[] categoriesPoints = { Italian.points, Chinese.points, Mexican.points, American.points };

        System.out.println("To begin the game type 1");
        // begins the game
        String gameInp = thing.nextLine();
        while (true) {
            if (gameInp.equals("1")) {
                break;
            } else {
                System.out.println("Please type 1");
                gameInp = thing.nextLine();
            }
        }

        for (int i = 0; i < QuestionCount.length; i++) {
            // reads for user input of any type
            // use the question list to print the question and answer each iteration of the
            // for loop
            String askq = (QuestionCount[i].label);
            System.out.println(askq);
            QuestionCount[i].bang();

            System.out.println("Please enter a # btwn 1 and 4");

            String userInput = thing.nextLine();
            // checks if the user input is valid
            if (userInput.equals("1") || userInput.equals("2") || userInput.equals("3") || userInput.equals("4")) {
                // translates the user input into a integer
                int userInputInt = Integer.parseInt(userInput);

                // sets a variable equal to the index of the list and adds to the
                Category index = categories[userInputInt - 1];
                index.points++;

                // take the userInput and make it the index to check what category the answer is
            } else {
                // if the input is not 1-4 or not an integer repeat
                System.out.println("Input a number between 1-4");
                userInput = thing.nextLine();

            }
        }

        int index = getMostPopularCatIndex(categoriesPoints);
        System.out.println("If you were a nationality of a food, you would be " + categories[index].label + ". ");
        System.out.println(categories[index].description);

        thing.close();
    }

    public static int getMostPopularCatIndex(int[] categoriesPoints) {
        // returns the index that is the max
        int maxCount = 0;
        int maxIndex = 0;
        for (int i = 0; i < categoriesPoints.length; i++) {
            if (categoriesPoints[i] > maxCount) {
                maxCount = categoriesPoints[i];
                maxIndex = i;
            }
            
        }
        return maxIndex;
    }
}
// find a way to elegantly add all of the points of the categories to a list
// take the list find the largest value
// if two values are equal random