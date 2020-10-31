package trivia;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for methods to read in JSON data.
 *
 * @author Selena Qian
 */
public class DataReader {
    /** Reads in questions from a JSON data file. Parses out each question and creates data structures to hold them accordingly.
     * @param filename the file to read data from.
     */
    public static List<Question> readData(String filename) throws IOException, ParseException {
        List<Question> questions = new ArrayList<>();
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
        return questions;
    }
}
