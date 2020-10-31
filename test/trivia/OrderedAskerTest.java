package trivia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderedAskerTest {
    Asker ask1;

    @BeforeEach
    void start() {
        ask1 = new OrderedAsker();
    }

    @Test
    void testReadData1QSelect() {
        ask1.readData("test-1question.json");
        assertEquals("What was Tandem previous name?\nA. Devmynd\nB. Tandem\nC. Burger Shack\nD. Extraordinary Humans\n", ask1.selectQuestion(1));
    }

    @Test
    void testReadData3QSelect() {
        ask1.readData("test-3question.json");
        assertEquals("What was Tandem previous name?\nA. Devmynd\nB. Tandem\nC. Burger Shack\nD. Extraordinary Humans\n", ask1.selectQuestion(1));
        assertEquals("In Shakespeare's play Julius Caesar, Caesar's last words were...\nEt tu, Brute?\nIacta alea est!\nVidi, vini, vici\nAegri somnia vana\n", ask1.selectQuestion(1));
        assertEquals("A group of tigers are referred to as:\nA. Ambush\nB. Chowder\nC. Pride\nD. Destruction\n", ask1.selectQuestion(1));
    }
}