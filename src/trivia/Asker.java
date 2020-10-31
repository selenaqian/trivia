package trivia;

import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Defines the methods that every class that handles reading and asking questions should have.
 */
public interface Asker {
    /**
     * Chooses which question will be shown.
     * @return String containing question and list of answer choices.
     */
    public String selectQuestion(int randomSeed);

    /**
     * Reads in questions from a JSON data file. Parses out each question and creates data structures to hold them accordingly.
     * @param filename the file to read data from.
     */
    public void readData(String filename) throws IOException, ParseException;
}
