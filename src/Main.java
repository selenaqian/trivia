import org.json.simple.parser.ParseException;
import trivia.OrderedAsker;
import trivia.Player;
import trivia.RandomAsker;
import trivia.TriviaGame;

import java.io.IOException;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

import static trivia.TriviaGame.DEFAULT_RESOURCES;

/**
 * This class launches the trivia game and plays one time through. It initially prompts for the type of game to create -
 * asking questions in the given order or random order. It could potentially ask for more setup information from the user if desired.
 * @author Selena Qian
 */
public class Main {
    public static void main (String[] args) {
        ResourceBundle resources = ResourceBundle.getBundle(DEFAULT_RESOURCES);
        while (true) {
            System.out.println(resources.getString("gameType"));
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            if (input.length() != 1 || !Character.isAlphabetic(input.charAt(0)) || input.toUpperCase().charAt(0) - 'A' > 1) {
                System.out.println(resources.getString("invalidType"));
            }
            else {
                try {
                    if (input.toUpperCase().charAt(0) == 'A') {
                        TriviaGame game = new TriviaGame(new OrderedAsker("data/Apprentice_TandemFor400_Data.json"), new Player());
                        game.play();
                        return;
                    }
                    else if (input.toUpperCase().charAt(0) == 'B') {
                        TriviaGame game = new TriviaGame(new RandomAsker("data/Apprentice_TandemFor400_Data.json"), new Player());
                        game.play();
                        return;
                    }
                }
                catch(Exception e){
                    if (e.getClass().isInstance(IOException.class)) {
                        System.out.println(resources.getString("invalidFile"));
                    }
                    else if (e.getClass().isInstance(ParseException.class)) {
                        System.out.println(resources.getString("badJSON"));
                    }
                }
            }
        }
    }
}
