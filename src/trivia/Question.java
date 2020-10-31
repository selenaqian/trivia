package trivia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        return prompt;
    }

    public List<String> getAnswerChoices(int randomSeed) {
        List<String> allAnswers = new ArrayList<>();
        allAnswers.addAll(incorrect);

        int random = new Random(randomSeed).nextInt(incorrect.size());
        allAnswers.add(random, correct);

        return allAnswers;
    }

    public Boolean isCorrect(String guess) {
        return guess.equals(correct);
    }

    public String getCorrect() {
        return correct;
    }
}
