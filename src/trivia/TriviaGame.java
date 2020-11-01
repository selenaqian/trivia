package trivia;

import java.util.*;

public class TriviaGame {
    public static final String DEFAULT_RESOURCES = "English";
    private Asker ask;
    private Player user;
    private Map<String, String> answerChoices;
    private ResourceBundle resources;

    public TriviaGame (Asker askIn, Player userIn) {
        ask = askIn;
        user = userIn;
        resources = ResourceBundle.getBundle(DEFAULT_RESOURCES);
        answerChoices = new HashMap<>();
    }

    public void play() {
        play(10, new Random().nextInt());
    }

    public void play(int numberQuestions, int randomSeed) {
        System.out.println(resources.getString("introduction"));
        int i = 0;
        Question q = ask.selectQuestion(randomSeed);
        while (i < numberQuestions) {
            printQuestion(randomSeed, i, q);
            String input = getInput();
            if (isValidAnswer(input)) {
                if (q.isCorrect(answerChoices.get(input.toUpperCase()))) {
                    printAnswerResponse(resources.getString("correct"), 1);
                }
                else {
                    printAnswerResponse(String.format("%s %s", resources.getString("incorrect"), q.getCorrect()), 0);
                }
                i++;
                if (i < numberQuestions) q = ask.selectQuestion(randomSeed);
            }
            else {
                System.out.println(resources.getString("invalidAnswer"));
            }
        }
        System.out.println(String.format("%s %d", resources.getString("final"), user.updateScore(0)));
    }

    private String getInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    private void printQuestion(int randomSeed, int i, Question q) {
        String prompt = q.getPrompt();
        StringBuilder answers = formatAnswers(randomSeed, q);
        System.out.println(String.format("%d. %s\n%s%s", i+1, prompt, answers, resources.getString("yourAnswer")));
    }

    private void printAnswerResponse(String response, int points) {
        System.out.println(response);
        System.out.println(String.format("%s %d", resources.getString("score"), user.updateScore(points)));
    }

    private boolean isValidAnswer(String input) {
        return input.length() == 1 && Character.isAlphabetic(input.charAt(0)) && input.toUpperCase().charAt(0) - 'A' < answerChoices.size();
    }

    private StringBuilder formatAnswers(int randomSeed, Question q) {
        StringBuilder answers = new StringBuilder();
        Character option = 'A';
        for (String ans : q.getAnswerChoices(randomSeed)) {
            answerChoices.put(option.toString(), ans);
            answers.append(String.format("%c. %s\n", option, ans));
            option++;
        }
        return answers;
    }
}
