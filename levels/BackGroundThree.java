//ID: 315786228
package levels;

import arkanoid.Sprite;
import biuoop.DrawSurface;
import geometry.Height;
import geometry.Width;

import java.awt.Color;
/**
 * A sprites backGround.
 */
public class BackGroundThree implements Sprite {
    /**
     * constructor.
     *
     */
    public BackGroundThree() {
    }
    @Override
    public void drawOn(DrawSurface d) {
        Color myColor = new Color(0, 153, 0);
        d.setColor(myColor);
        d.fillRectangle(0, 0, Width.WIDTH, Height.HEIGHT);
        myColor = new Color(255, 102, 120);
        d.setColor(myColor);
        d.fillCircle(130, 200, 12);
        d.setColor(Color.red);
        d.fillCircle(130, 200, 9);
        d.setColor(Color.white);
        d.fillCircle(130, 200, 3);
        myColor = new Color(102, 102, 102);
        d.setColor(myColor);
        d.fillRectangle(126, 212, 8, 180);
        myColor = new Color(51, 51, 51);
        d.setColor(myColor);
        d.fillRectangle(118, 392, 24, 60);
        d.setColor(Color.BLACK);
        d.fillRectangle(94, 452, 72, 148);
        d.setColor(Color.WHITE);
        int x = 98, y = 456, block = 8, blockHeight = 20;
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 4; j++) {
                d.fillRectangle(x, y, block, blockHeight);
                x += 14;
            }
            y += 26;
            x = 98;
        }

    }

    @Override
    public void timePassed() {

    }

}
