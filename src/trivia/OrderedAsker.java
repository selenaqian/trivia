package trivia;

import org.json.simple.parser.ParseException;

import java.io.IOException;
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
    public Question selectQuestion(int randomSeed) {
        Question q = questions.get(0);
        questions.remove(0);
        return q;
    }
}
