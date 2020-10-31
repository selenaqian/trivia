package trivia;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;
import java.util.Random;

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
    public Question selectQuestion(int randomSeed) {
        int index = new Random(randomSeed).nextInt(remaining.size());
        Question selected = remaining.get(index);
        remaining.remove(index);
        return selected;
    }
}
