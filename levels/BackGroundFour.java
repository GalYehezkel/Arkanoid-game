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
public class BackGroundFour implements Sprite {
    /**
     * constructor.
     *
     */
    public BackGroundFour() {
    }
    @Override
    public void drawOn(DrawSurface d) {
        Color myColor = new Color(51, 153, 255);
        d.setColor(myColor);
        d.fillRectangle(0, 0, Width.WIDTH, Height.HEIGHT);
        d.setColor(Color.WHITE);
        for (int i = 110; i <= 170; i += 6) {
            d.drawLine(i, 390, i - 20, 600);
        }
      //  d.drawLine(120, 390, 100, 600);
        myColor = new Color(204, 204, 204);
        d.setColor(myColor);
        d.fillCircle(120, 390, 19);
        myColor = new Color(204, 204, 204);
        d.setColor(myColor);
        d.fillCircle(110, 365, 16);
        myColor = new Color(153, 153, 153);
        d.setColor(myColor);
        d.fillCircle(140, 365, 20);
        myColor = new Color(102, 102, 102);
        d.setColor(myColor);
        d.fillCircle(160, 380, 22);
        myColor = new Color(102, 102, 102);
        d.setColor(myColor);
        d.fillCircle(140, 390, 16);

        d.setColor(Color.WHITE);
        for (int i = 610; i <= 670; i += 6) {
            d.drawLine(i, 540, i - 20, 600);
        }
        //  d.drawLine(120, 390, 100, 600);
        myColor = new Color(204, 204, 204);
        d.setColor(myColor);
        d.fillCircle(620, 540, 19);
        myColor = new Color(204, 204, 204);
        d.setColor(myColor);
        d.fillCircle(610, 515, 16);
        myColor = new Color(153, 153, 153);
        d.setColor(myColor);
        d.fillCircle(640, 515, 20);
        myColor = new Color(102, 102, 102);
        d.setColor(myColor);
        d.fillCircle(660, 530, 22);
        myColor = new Color(102, 102, 102);
        d.setColor(myColor);
        d.fillCircle(640, 540, 16);

    }

    @Override
    public void timePassed() {

    }
}
