// import java.util.Scanner;

public class Question {
    String label;
    Answer[] possibleAnswers = new Answer[4];

    Question(String label) {
        this.label = label;
    }

    public void bang() {
        System.out.println("The choices are:");
        //for each possible answer within the question print the label of the question
        for (int I = 0; I < this.possibleAnswers.length; I++) {
            System.out.println(I + 1 + ") " + this.possibleAnswers[I].label);
        }
    }
}
