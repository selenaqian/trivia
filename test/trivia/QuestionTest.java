package trivia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {
    Question test1;

    @BeforeEach
    void start() {
        test1 = new Question("test question?", Arrays.asList(new String[]{"12", "54", "3"}), "8");
    }

    @Test
    void testGetPromptSimple() {
        assertEquals("test question?", test1.getPrompt());
    }

    @Test
    void testGetAnswerChoicesRandomSeed1() {
        List<String> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(new String[]{"12", "54", "3"}));
        int random = new Random(1).nextInt(expected.size());
        expected.add(random, "8");
        assertEquals(expected, test1.getAnswerChoices(1));
    }

    @Test
    void testGetAnswerChoicesRandomSeed3() {
        List<String> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(new String[]{"12", "54", "3"}));
        int random = new Random(3).nextInt(expected.size());
        expected.add(random, "8");
        assertEquals(expected, test1.getAnswerChoices(3));
    }

    @Test
    void testIsCorrect() {
        assertFalse(test1.isCorrect("4"));
        assertTrue(test1.isCorrect("8"));
    }
}