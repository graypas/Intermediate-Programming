package New1;

import java.io.*;

public interface Game {
    String getGameName();

    void play(); // must be able to play a game

    String getScore(int score1); // get a score - if there is no "score" then we

    void writeHighScore(File f, String score2); // writes the high score of this game to a file.
}
