//ID: 315786228
package levels;

import arkanoid.Block;
import arkanoid.Sprite;
import biuoop.DrawSurface;
import geometry.Height;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Width;

import java.awt.Color;
/**
 * A sprites backGround.
 */
public class BackGroundOne implements Sprite {
    private Block block;
    /**
     * constructor.
     *
     * @param block Block.
     */
    public BackGroundOne(Block block) {
        this.block = block;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, Width.WIDTH, Height.HEIGHT);
        d.setColor(Color.blue);
        Rectangle rec = block.getCollisionRectangle();
        Point middleOfBlockUp = new Line(rec.getUpperLeft(), rec.getUpperRight()).middle();
        Point middleOfBlockDown = new Line(rec.getDownLeft(), rec.getDownRight()).middle();
        Point middleOfBlockRight = new Line(rec.getUpperRight(), rec.getDownRight()).middle();
        Point middleOfBlockLeft = new Line(rec.getUpperLeft(), rec.getDownLeft()).middle();
        Point middleOfblock = new Line(middleOfBlockDown, middleOfBlockUp).middle();
        d.drawLine((int) middleOfBlockRight.getX() + 5, (int) middleOfBlockRight.getY(),
                (int) middleOfBlockRight.getX() + 110, (int) middleOfBlockRight.getY()); //right line.
        d.drawLine((int) middleOfBlockLeft.getX() - 5, (int) middleOfBlockLeft.getY(),
                (int) middleOfBlockLeft.getX() - 110, (int) middleOfBlockLeft.getY()); //left line.
        d.drawLine((int) middleOfBlockUp.getX(), (int) middleOfBlockUp.getY() - 5,
                (int) middleOfBlockUp.getX(), (int) middleOfBlockUp.getY() - 110); //up line.
        d.drawLine((int) middleOfBlockDown.getX(), (int) middleOfBlockDown.getY() + 5,
                (int) middleOfBlockDown.getX(), (int) middleOfBlockDown.getY() + 110); //down line.
        d.drawCircle((int) middleOfblock.getX(), (int) middleOfblock.getY(), 50); //small circle.
        d.drawCircle((int) middleOfblock.getX(), (int) middleOfblock.getY(), 80); //medium circle.
        d.drawCircle((int) middleOfblock.getX(), (int) middleOfblock.getY(), 110); //big circle.
    }

    @Override
    public void timePassed() {

    }
}
