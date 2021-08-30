//ID: 315786228
package arkanoid;

import levels.LevelInformation;
import arkanoidstats.Counter;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * A game flow that runs the levels.
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private Counter score;
    /**
     * constructor.
     * @param ar the animation runner.
     * @param ks the keyboard sensor.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.score = new Counter();
    }
    /**
     * runs all the levels in the list, if the player wins display a winning screen, else game over,
     * both screens shows the score of the player.
     * @param levels a list of level information.
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.animationRunner, this.keyboardSensor, this.score);
            level.initialize();

            while (level.numOfBallsRemain() > 0 && level.numOfBlocksRemain() > 0) {
                level.run();
            }

            if (level.numOfBallsRemain() == 0) {
                GameLose gameLose = new GameLose(keyboardSensor, score);
                animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY, gameLose));
                return;
            }
        }
        GameWin gameWin = new GameWin(keyboardSensor, score);
        animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY, gameWin));
    }
}