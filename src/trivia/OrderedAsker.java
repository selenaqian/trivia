package trivia;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class assumes that the JSON data file contains questions in order and will present them in order in the rounds.
 *
 * @author Selena Qian
 */
public class OrderedAsker implements Asker {
    private List<Question> questions;
    private int currentQuestion;

    public OrderedAsker() {
        questions = new ArrayList<>();
        currentQuestion = 0;
    }

    @Override
    public String selectQuestion(int randomSeed) {
        String prompt = questions.get(currentQuestion).getPrompt();
        StringBuilder answers = new StringBuilder();
        Character option = 'A';
        for (String ans : questions.get(currentQuestion).getAnswerChoices(randomSeed)) {
            answers.append(String.format("%c. %s\n", option, ans));
            option++;
        }
        currentQuestion++;
        return prompt + "\n" + answers;
    }

    @Override
    public void readData(String filename) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader(filename));
        JSONArray json = (JSONArray) obj;
        for (Object question : json) {
            JSONObject jsonQuestion = (JSONObject) question;

            String prompt = (String) jsonQuestion.get("question");
            JSONArray incorrectArray = (JSONArray) jsonQuestion.get("incorrect");
            List<String> incorrectList = new ArrayList<>();
            for (Object answer : incorrectArray) {
                incorrectList.add((String) answer);
            }
            String correct = (String) jsonQuestion.get("correct");

            questions.add(new Question(prompt, incorrectList, correct));
        }
    }
}
