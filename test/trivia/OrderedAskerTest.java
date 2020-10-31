package trivia;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OrderedAskerTest {
    @Test
    void testReadData1QSelect() throws IOException, ParseException {
        Asker ask = new OrderedAsker("data/test/test-1question.json");
        Question first = ask.selectQuestion(1);
        assertEquals("What was Tandem previous name?", first.getPrompt());
        assertEquals("Devmynd", first.getAnswerChoices(1).get(0));
        assertEquals("Tandem", first.getAnswerChoices(1).get(1));
        assertEquals("Burger Shack", first.getAnswerChoices(1).get(2));
        assertEquals("Extraordinary Humans", first.getAnswerChoices(1).get(3));    }

    @Test
    void testReadData3QSelect() throws IOException, ParseException {
        Asker ask = new OrderedAsker("data/test/test-3questions.json");
        ask.selectQuestion(1);
        Question second = ask.selectQuestion(1);
        Question third = ask.selectQuestion(1);

        assertEquals("In Shakespeare's play Julius Caesar, Caesar's last words were...", second.getPrompt());
        assertEquals("Et tu, Brute?", second.getAnswerChoices(1).get(0));
        assertEquals("Iacta alea est!", second.getAnswerChoices(1).get(1));
        assertEquals("Vidi, vini, vici", second.getAnswerChoices(1).get(2));
        assertEquals("Aegri somnia vana", second.getAnswerChoices(1).get(3));

        assertEquals("A group of tigers are referred to as:", third.getPrompt());
        assertEquals("Ambush", third.getAnswerChoices(1).get(0));
        assertEquals("Chowder", third.getAnswerChoices(1).get(1));
        assertEquals("Pride", third.getAnswerChoices(1).get(2));
        assertEquals("Destruction", third.getAnswerChoices(1).get(3));
    }

    @Test
    void testMissingFile() {
        assertThrows(IOException.class, () -> new RandomAsker("data/test/fake.json"));
    }

    @Test
    void testParseError() {
        assertThrows(ParseException.class, () -> new RandomAsker("data/test/badjson.json"));
    }
}