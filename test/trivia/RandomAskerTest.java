package trivia;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RandomAskerTest {
    Asker ask1;

    @BeforeEach
    void start() {
        ask1 = new RandomAsker();
    }

    @Test
    void testReadData1QSelect() throws IOException, ParseException {
        ask1.readData("data/test/test-1question.json");
        assertEquals("What was Tandem previous name?\nA. Devmynd\nB. Tandem\nC. Burger Shack\nD. Extraordinary Humans\n", ask1.selectQuestion(1));
    }

    @Test
    void testReadData3QSelect() throws IOException, ParseException {
        ask1.readData("data/test/test-3questions.json");
        assertEquals("In Shakespeare's play Julius Caesar, Caesar's last words were...\nA. Et tu, Brute?\nB. Iacta alea est!\nC. Vidi, vini, vici\nD. Aegri somnia vana\n", ask1.selectQuestion(1));
        assertEquals("A group of tigers are referred to as:\nA. Ambush\nB. Chowder\nC. Pride\nD. Destruction\n", ask1.selectQuestion(1));
        assertEquals("What was Tandem previous name?\nA. Devmynd\nB. Tandem\nC. Burger Shack\nD. Extraordinary Humans\n", ask1.selectQuestion(1));
    }
}