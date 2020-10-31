package trivia;

public class Player {
    private int score;

    public Player() {
        new Player(0);
    }

    public Player(int scoreIn) {
        score = scoreIn;
    }

    private int updateScore() {
        return updateScore(1);
    }

    private int updateScore(int points) {
        score+=points;
        return score;
    }

    public int handleGuess(String guess, Question q) {
        if (q.isCorrect(guess)) {
            updateScore();
        }
        return score;
    }
}
