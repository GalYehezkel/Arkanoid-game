//ID: 315786228
package levels;

import arkanoid.Block;
import arkanoid.Sprite;
import arkanoid.Velocity;
import geometry.Point;
import geometry.Rectangle;
import geometry.Width;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Level one.
 */
public class LevelOne implements LevelInformation {
    /**
     * constructor.
     *
     */
    public LevelOne() {

    }
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ls = new ArrayList<>();
        Random rand = new Random(); // create a random-number generator
        Velocity velocity = new Velocity(0, -3);
        ls.add(velocity);
        return ls;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 70;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new BackGroundOne(blocks().get(0));
    }

    @Override
    public List<Block> blocks() {
        List<Block> ls = new ArrayList<>();
        ls.add(new Block(new Rectangle(new Point(Width.WIDTH / 2, 150), 30, 30), Color.RED));
        return ls;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
