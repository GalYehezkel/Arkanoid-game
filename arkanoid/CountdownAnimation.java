//ID: 315786228
package arkanoid;

import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;


/**
 *  The CountdownAnimation will display the given gameScreen,
 *  for numOfSeconds seconds, and on top of them it will show
 *  a countdown from countFrom back to 1, where each number will
 *  appear on the screen for (numOfSeconds / countFrom) seconds, before
 *  it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private Sleeper sleeper;
    private long timePerFrame;
    private boolean stop;
    /**
     * constructor.
     * @param numOfSeconds the long of the count.
     * @param countFrom number to count from.
     * @param gameScreen sprite collection.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.sleeper = new Sleeper();
        timePerFrame = (long) (1000 * numOfSeconds / countFrom);
        this.stop = false;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        if (numOfSeconds >= 0) {
            Color myColor = new Color(0, 153, 0);
            d.setColor(myColor);
            d.fillRectangle(0, 0, 800, 600);
            d.setColor(Color.BLACK);
            gameScreen.drawAllOn(d);
            d.setColor(Color.BLACK);
            d.drawText(200, 18, "Starts in:" + this.countFrom + " seconds", 20);
            if (numOfSeconds != 3) {
                this.sleeper.sleepFor(timePerFrame);
            }
            countFrom--;
            numOfSeconds--;
        } else {
            stop = true;
        }
    }
    @Override
    public boolean shouldStop() {
        return stop;
    }
}
