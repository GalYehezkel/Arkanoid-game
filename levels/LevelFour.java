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
public class LevelFour implements LevelInformation {
    private java.awt.Color[] color = new Color[7];
    private int widthOfCollidable, heightOfBlock = 10, numberOfBlocks = 15, heightOfCollidable = 20,
            heightOfTheRow = heightOfBlock + 4 * heightOfCollidable, numbersOfRows = 7;
    /**
     * constructor.
     *
     */
    public LevelFour() {
        color[0] = Color.GRAY;
        color[1] = Color.RED;
        color[2] = Color.YELLOW;
        color[3] = Color.GREEN;
        color[4] = Color.WHITE;
        color[5] = Color.pink;
        color[6] = Color.cyan;
        widthOfCollidable = (Width.WIDTH - 20) / numberOfBlocks;
    }
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ls = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            int angle = 310 + i * 45;
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
        return 70;
    }

    @Override
    public String levelName() {
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        return new BackGroundFour();
    }
    /**
     * adds rows of blocks to the list.
     *
     * @param k the index for the colors array.
     * @param ls list of blocks.
     */
    public void addRowOfBlocks(int k, List<Block> ls) {
        int locationOfBlockX = Width.WIDTH - heightOfBlock - widthOfCollidable; // location to put the block X.
        for (int i = 0; i < numberOfBlocks; i++) {
            Block block = new Block(new Rectangle(new Point(locationOfBlockX, heightOfTheRow),
                    widthOfCollidable, heightOfCollidable), color[k]);
            ls.add(block);
            locationOfBlockX = locationOfBlockX - widthOfCollidable; // update the location for next block in X.
        }
        heightOfTheRow = heightOfTheRow + heightOfCollidable; // update location Y for the next row.
    }
    @Override
    public List<Block> blocks() {
        List<Block> ls = new ArrayList<>();
        for (int i = 0; i < numbersOfRows; i++) { //create rows of blocks and add them to the game.
            addRowOfBlocks(i, ls);
        }
        return ls;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
