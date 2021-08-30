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
public class LevelThree implements LevelInformation {
    private java.awt.Color[] color = new Color[5];
    private int widthOfCollidable = 50, heightOfBlock = 10, numberOfBlocks = 10, heightOfCollidable = 20,
            heightOfTheRow = heightOfBlock + 6 * heightOfCollidable, numbersOfRows = 5;
    /**
     * constructor.
     *
     */
    public LevelThree() {
        color[0] = Color.GRAY;
        color[1] = Color.RED;
        color[2] = Color.YELLOW;
        color[3] = Color.BLUE;
        color[4] = Color.WHITE;
    }
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ls = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            int angle = 310 + i * 100;
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
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        return new BackGroundThree();
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
        numberOfBlocks--; // update number of blocks for the next row.
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
