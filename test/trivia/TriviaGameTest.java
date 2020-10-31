package trivia;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;

import java.io.*;
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
        System.setIn(new ByteArrayInputStream("A".getBytes()));
        game.play(1, 1);
        assertEquals(String.format("%s\n1. %s\n%s \n%s\n%s 1", introduction, askTest.selectQuestion(1), yourAnswer, correct, finalText), outContent.toString());
    }

    @Test
    void testPlay3QOrdered() throws IOException, ParseException {
        Asker ask = new OrderedAsker("data/test/test-3questions.json");
        Asker askTest = new OrderedAsker("data/test/test-3questions.json");
        TriviaGame game = new TriviaGame(ask, new Player());
        System.setIn(new ByteArrayInputStream("AAA".getBytes()));
        game.play(3, 1);
        StringBuilder expected = new StringBuilder();
        expected.append(String.format("%s\n", introduction));
        for (int i = 0; i < 3; i++) {
            expected.append(String.format("%d. %s\n%s \n%s\n%s %d\n", i+1, askTest.selectQuestion(1), yourAnswer, correct, score, i+1));
        }
        expected.append(String.format("%s 3", score));
        assertEquals(expected, outContent.toString());
    }

    @Test
    void testPlay3QRandom() throws IOException, ParseException {
        Asker ask = new RandomAsker("data/test/test-3questions.json");
        Asker askTest = new RandomAsker("data/test/test-3questions.json");
        TriviaGame game = new TriviaGame(ask, new Player());
        System.setIn(new ByteArrayInputStream("AAA".getBytes()));
        game.play(3, 1);
        StringBuilder expected = new StringBuilder();
        expected.append(String.format("%s\n", introduction));
        for (int i = 0; i < 3; i++) {
            expected.append(String.format("%d. %s\n%s \n%s\n%s %d\n", i+1, askTest.selectQuestion(1), yourAnswer, correct, score, i+1));
        }
        expected.append(String.format("%s 3", score));
        assertEquals(expected, outContent.toString());
    }
}