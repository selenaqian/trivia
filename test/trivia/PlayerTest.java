package trivia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Question test1;
    Player p1;

    @BeforeEach
    void start() {
        test1 = new Question("test question?", Arrays.asList(new String[]{"12", "54", "3"}), "8");
        p1 = new Player();
    }

    @Test
    void testHandleGuessCorrect() {
        assertEquals(1, p1.handleGuess("8"));
    }

    @Test
    void testHandleGuessIncorrect() {
        assertEquals(0, p1.handleGuess("12"));
        assertEquals(0, p1.handleGuess("abcd"));
    }

    @Test
    void testHandleGuessIncorrectStartPoints() {
        Player p2 = new Player(5);
        assertEquals(5, p2.handleGuess("12"));
        assertEquals(5, p2.handleGuess("abcd"));
    }

    @Test
    void testHandleMultipleGuesses() {
        assertEquals(0, p1.handleGuess("12"));
        assertEquals(1, p1.handleGuess("8"));
        assertEquals(2, p1.handleGuess("8"));
        assertEquals(3, p1.handleGuess("8"));
        assertEquals(3, p1.handleGuess("54"));
        assertEquals(3, p1.handleGuess("3"));
    }
}