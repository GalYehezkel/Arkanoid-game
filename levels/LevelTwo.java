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

/**
 * Level one.
 */
public class LevelTwo implements LevelInformation {
    /**
     * constructor.
     *
     */
    public LevelTwo() {

    }
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ls = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            int angle = 310 + i * 10;
            double dx = Velocity.fromAngleAndSpeed(angle, 3).getDx();
            double dy = Velocity.fromAngleAndSpeed(-angle, 3).getDy();
            Velocity velocity = new Velocity(dx, dy);
            ls.add(velocity);
        }
        return ls;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 700;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return new BackGroundTwo();
    }

    @Override
    public List<Block> blocks() {
        List<Block> ls = new ArrayList<>();
        int sizeOfBlock = (Width.WIDTH - 20) / 15;
        int numberOfBlocks = 15;
        Point end = new Point(Width.WIDTH - 10 - sizeOfBlock, 250);
        while (numberOfBlocks != 0) {
            if (numberOfBlocks <= 15 && numberOfBlocks > 13) {
                ls.add(new Block(new Rectangle(end, sizeOfBlock, 30), Color.CYAN));
            } else if (numberOfBlocks <= 13 && numberOfBlocks > 11) {
                ls.add(new Block(new Rectangle(end, sizeOfBlock, 30), Color.pink));
            } else if (numberOfBlocks <= 11 && numberOfBlocks > 9) {
                ls.add(new Block(new Rectangle(end, sizeOfBlock, 30), Color.BLUE));
            } else if (numberOfBlocks <= 9 && numberOfBlocks > 6) {
                ls.add(new Block(new Rectangle(end, sizeOfBlock, 30), Color.green));
            } else if (numberOfBlocks <= 6 && numberOfBlocks > 4) {
                ls.add(new Block(new Rectangle(end, sizeOfBlock, 30), Color.yellow));
            } else if (numberOfBlocks <= 4 && numberOfBlocks > 2) {
                ls.add(new Block(new Rectangle(end, sizeOfBlock, 30), Color.orange));
            } else if (numberOfBlocks <= 2 && numberOfBlocks > 0) { //
                ls.add(new Block(new Rectangle(end, sizeOfBlock, 30), Color.red));
            }
            end = new Point(end.getX() - sizeOfBlock, end.getY());
            numberOfBlocks--;
        }
        return ls;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
