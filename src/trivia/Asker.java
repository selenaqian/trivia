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
}
