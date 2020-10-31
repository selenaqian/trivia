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
            String prompt = q.getPrompt();
            StringBuilder answers = new StringBuilder();
            Character option = 'A';
            for (String ans : q.getAnswerChoices(randomSeed)) {
                answerChoices.put(option.toString(), ans);
                answers.append(String.format("%c. %s\n", option, ans));
                option++;
            }
            System.out.println(String.format("%d. %s\n%s%s", i+1, prompt, answers, resources.getString("yourAnswer")));

            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            if (input.length() > 1 || !Character.isAlphabetic(input.charAt(0)) || input.toUpperCase().charAt(0) - 'A' >= answerChoices.size()) {
                System.out.println(resources.getString("invalidAnswer"));
            }
            else {
                i++;
                if (q.isCorrect(answerChoices.get(input.toUpperCase()))) {
                    System.out.println(resources.getString("correct"));
                    System.out.println(String.format("%s %d", resources.getString("score"), user.updateScore()));
                }
                else {
                    System.out.println(String.format("%s %s", resources.getString("incorrect"), q.getCorrect()));
                    System.out.println(String.format("%s %d", resources.getString("score"), user.updateScore(0)));
                }
                if (i < numberQuestions) q = ask.selectQuestion(randomSeed);
            }
        }
        System.out.println(String.format("%s %d", resources.getString("final"), user.updateScore(0)));
    }
}
