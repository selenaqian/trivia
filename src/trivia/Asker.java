package trivia;

/**
 * Defines the methods that every class that handles reading and asking questions should have.
 */
public interface Asker {
    public String selectQuestion();
    public void readData(String filename);
}
