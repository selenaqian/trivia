package trivia;

public class Player {
    private int score;

    public Player() {
        new Player(0);
    }

    public Player(int scoreIn) {
        score = scoreIn;
    }

    public int updateScore() {
        return updateScore(1);
    }

    public int updateScore(int points) {
        score+=points;
        return score;
    }
}
