package trivia;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.Random;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;

class TriviaGameTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    private ResourceBundle properties;
    private String introduction;
    private String yourAnswer;
    private String correct;
    private String score;
    private String incorrect;
    private String finalText;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        properties = ResourceBundle.getBundle("English");
        introduction = properties.getString("introduction");
        yourAnswer = properties.getString("yourAnswer");
        correct = properties.getString("correct");
        score = properties.getString("score");
        incorrect = properties.getString("incorrect");
        finalText = properties.getString("final");
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void testPlay1QOrdered() throws IOException, ParseException {
        Asker ask = new OrderedAsker("data/test/test-1question.json");
        Asker askTest = new OrderedAsker("data/test/test-1question.json");
        TriviaGame game = new TriviaGame(ask, new Player());
        System.setIn(new ByteArrayInputStream("C".getBytes()));

        game.play(1, 1, new Random(1));
        Question q = askTest.selectQuestion(1);
        StringBuilder answers = getAnswerChoicesString(q);
        assertEquals(String.format("%s\n1. %s\n%s%s\n%s\n%s 1\n%s 1\n", introduction, q.getPrompt(), answers, yourAnswer, correct, score, finalText), outContent.toString());
    }

    @Test
    void testPlay1QOrderedIncorrect() throws IOException, ParseException {
        Asker ask = new OrderedAsker("data/test/test-1question.json");
        Asker askTest = new OrderedAsker("data/test/test-1question.json");
        TriviaGame game = new TriviaGame(ask, new Player());
        System.setIn(new ByteArrayInputStream("B".getBytes()));

        game.play(1, 1, new Random(1));
        Question q = askTest.selectQuestion(1);
        StringBuilder answers = getAnswerChoicesString(q);
        assertEquals(String.format("%s\n1. %s\n%s%s\n%s %s\n%s 0\n%s 0\n", introduction, q.getPrompt(), answers, yourAnswer, incorrect, q.getCorrect(), score, finalText), outContent.toString());
    }

    private StringBuilder getAnswerChoicesString(Question q) {
        StringBuilder answers = new StringBuilder();
        Character option = 'A';
        for (String ans : q.getAnswerChoices(new Random(1).nextInt())) {
            answers.append(String.format("%c. %s\n", option, ans));
            option++;
        }
        return answers;
    }
}