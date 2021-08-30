//ID: 315786228
package levels;

import arkanoid.Sprite;
import biuoop.DrawSurface;
import geometry.Height;
import geometry.Point;
import geometry.Width;

import java.awt.Color;
/**
 * A sprites backGround.
 */
public class BackGroundTwo implements Sprite {
    /**
     * constructor.
     *
     */
    public BackGroundTwo() {
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(0, 0, Width.WIDTH, Height.HEIGHT);
        d.setColor(Color.yellow);
        d.drawCircle(150, 160, 30); //small circle.
        d.drawCircle(150, 160, 40); //medium circle.
        d.drawCircle(150, 160, 50); //big circle.
        Color myColor = new Color(255, 255, 0);
        d.setColor(myColor);
        for (int i = 30; i <= 700; i += 10) {
            Point p = new Point(i, 250);
            d.drawLine((int) p.getX(), (int) p.getY(), 150, 160);
        }
        myColor = new Color(255, 255, 205);
        d.setColor(myColor);
        d.fillCircle(150, 160, 50); //big circle.
        myColor = new Color(255, 255, 100);
        d.setColor(myColor);
        d.fillCircle(150, 160, 40); //medium circle.
        myColor = new Color(255, 255, 0);
        d.setColor(myColor);
        d.fillCircle(150, 160, 30); //small circle.
    }

    @Override
    public void timePassed() {

    }

}
