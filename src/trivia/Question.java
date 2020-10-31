package trivia;

import java.util.List;

public class Question {
    private String prompt;
    private List<String> incorrect;
    private String correct;

    public Question(String promptIn, List<String> incorrectIn, String correctIn) {
        prompt = promptIn;
        incorrect = incorrectIn;
        correct = correctIn;
    }

    public String getPrompt() {
        return null;
    }

    public List<String> getAnswerChoices() {
        return getAnswerChoices(1);
    }

    public List<String> getAnswerChoices(int randomSeed) {
        return null;
    }

    public Boolean isCorrect(String guess) {
        return false;
    }
}
