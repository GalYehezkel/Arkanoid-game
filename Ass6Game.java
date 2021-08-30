//ID: 315786228

import levels.LevelFour;
import levels.LevelInformation;
import levels.LevelOne;
import levels.LevelThree;
import levels.LevelTwo;
import arkanoid.AnimationRunner;
import arkanoid.GameFlow;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import geometry.Height;
import geometry.Width;

import java.util.ArrayList;
import java.util.List;

/**
 * run a game with levels that contains balls, blocks and paddle.
 */
public class Ass6Game {
    /**
     * main. run a game with levels that contains balls, blocks and paddle.
     *
     * @param args  string[].
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", Width.WIDTH, Height.HEIGHT); // create board.
        KeyboardSensor keyboard = gui.getKeyboardSensor();
        AnimationRunner ar = new AnimationRunner(gui);
        List<LevelInformation> levels = new ArrayList<>();
        if (args.length == 0) {
            levels.add(new LevelOne());
            levels.add(new LevelTwo());
            levels.add(new LevelThree());
            levels.add(new LevelFour());
        } else {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("1")) {
                    levels.add(new LevelOne());
                }
                if (args[i].equals("2")) {
                    levels.add(new LevelTwo());
                }
                if (args[i].equals("3")) {
                    levels.add(new LevelThree());
                }
                if (args[i].equals("4")) {
                    levels.add(new LevelFour());
                }
            }
            if (levels.isEmpty()) {
                levels.add(new LevelOne());
                levels.add(new LevelTwo());
                levels.add(new LevelThree());
                levels.add(new LevelFour());
            }
        }
        GameFlow gameFlow = new GameFlow(ar, keyboard);
        gameFlow.runLevels(levels);
        gui.close();
    }
}
