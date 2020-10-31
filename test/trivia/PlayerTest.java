package trivia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player p1;

    @Test
    void testUpdateScore1() {
        p1 = new Player();
        assertEquals(1, p1.updateScore());
    }

    @Test
    void testUpdateScoreMultiple() {
        p1 = new Player();
        assertEquals(3, p1.updateScore(3));
        assertEquals(4, p1.updateScore(1));
    }

    @Test
    void testUpdateScoreNegative() {
        p1 = new Player();
        assertEquals(-1, p1.updateScore(-1));
    }

    @Test
    void testInitializeWithPoints() {
        p1 = new Player(3);
        assertEquals(3, p1.updateScore(0));
    }
}