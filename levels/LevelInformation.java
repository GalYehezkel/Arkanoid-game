//ID: 315786228
package levels;

import arkanoid.Block;
import arkanoid.Sprite;
import arkanoid.Velocity;

import java.util.List;
/**
 * An interface of level information.
 */
public interface LevelInformation {
    /**
     * return the number of balls.
     *
     * @return int number of balls.
     */
    int numberOfBalls();
    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    /**
     * return a list of velocity's members.
     * The initial velocity of each ball.
     *
     * @return List<Velocity> list of velocity.
     */
    List<Velocity> initialBallVelocities();
    /**
     * return the speed of the paddle.
     *
     *
     * @return int speed of paddle.
     */
    int paddleSpeed();
    /**
     * return the width of the paddle.
     *
     *
     * @return int width of the paddle.
     */
    int paddleWidth();
    // the level name will be displayed at the top of the screen.
    /**
     * return the level name will be displayed at the top of the screen.
     *
     *
     * @return String width of the paddle.
     */
    String levelName();
    // Returns a sprite with the background of the level
    /**
     * Returns a sprite with the background of the level.
     *
     *
     * @return Sprite of the back ground.
     */
    Sprite getBackground();
    // The Blocks that make up this level, each block contains
    // its size, color and location.
    /**
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return List<Block> list of blocks.
     */
    List<Block> blocks();
    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();
    /**
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     *
     *
     * @return int number of blocks to remove.
     */
    int numberOfBlocksToRemove();
}
