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

    public OrderedAsker(String filename) throws IOException, ParseException {
        questions = DataReader.readData(filename);
    }

    @Override
    public String selectQuestion(int randomSeed) {
        String prompt = questions.get(0).getPrompt();
        StringBuilder answers = new StringBuilder();
        Character option = 'A';
        for (String ans : questions.get(0).getAnswerChoices(randomSeed)) {
            answers.append(String.format("%c. %s\n", option, ans));
            option++;
        }
        questions.remove(0);
        return String.format("%s\n%s", prompt, answers);
    }
}
