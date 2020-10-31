import org.json.simple.parser.ParseException;
import trivia.OrderedAsker;
import trivia.Player;
import trivia.TriviaGame;

import java.io.IOException;
import java.util.Random;

/**
 * This class launches the trivia game and plays one time through.
 * @author Selena Qian
 */
public class Main {
    public static void main (String[] args) throws IOException, ParseException {
        TriviaGame game = new TriviaGame(new OrderedAsker("data/Apprentice_TandemFor400_Data.json"), new Player());
        game.play(10, new Random().nextInt());
    }
}
