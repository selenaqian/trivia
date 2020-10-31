package trivia;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RandomAsker implements Asker {
    List<Question> remaining;

    public RandomAsker(String filename) throws IOException, ParseException {
        remaining = DataReader.readData(filename);
    }

    /**
     * Randomly selects a question from the list of remaining unasked questions.
     * @param randomSeed used to seed the random value so that can have predictable results when desired. Used for both
     *                   randomizing which question asked and the order of answer choices.
     * @return formatted string with question prompt and answer choices.
     */
    @Override
    public String selectQuestion(int randomSeed) {
        return null;
    }
}
