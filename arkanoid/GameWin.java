//ID: 315786228
package arkanoid;

import arkanoidstats.Counter;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * A pause screen that pauses the game until space is pressed.
 */
public class GameWin implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter score;
    /**
     * constructor.
     *
     * @param k  keyboard sensor.
     * @param score score counter.
     */
    public GameWin(KeyboardSensor k, Counter score) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
    }
    /**
     * makes one frame and put the changes on the draw surface.
     *
     * @param d the surface to draw on.
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + score.getValue(), 32);
    }
    /**
     * checks if need to stop.
     *
     * @return boolean indicates if need to stop.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
