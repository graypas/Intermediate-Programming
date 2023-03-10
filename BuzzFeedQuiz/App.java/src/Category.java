// import java.util.ArrayList;

public class Category {
    String label;
    String description;
    int points = 0;
    static int instanceCounter;

    Category(String l, String description, int pts) {
        this.label = l;
        this.description = description;
        this.points = pts;
        this.instanceCounter++;
        // public ArrayList<Category> categories2 = new ArrayList<Category>();
    }

    // /**
    //  * 
    //  */
    // public void bop() {
    //     for (int b = 0; b < instanceCounter; b++) {
    //         categories2.add(this.Category);
    //     }
    //     for (int superI = 0; superI < categories2.size(); superI++) {
    //         int index2[] = { this.points };
    //         int[] pointCounter = {};
    //     }
    // }
}
