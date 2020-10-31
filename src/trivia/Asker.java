package trivia;

/**
 * Defines the methods that every class that handles reading and asking questions should have.
 */
public interface Asker {
    /**
     * Chooses which question will be shown.
     * @return String containing question and list of answer choices.
     */
    public Question selectQuestion(int randomSeed);
}
