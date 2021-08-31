//ID: 315786228
package arkanoid;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * A pause screen that pauses the game until space is pressed.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    /**
     * constructor.
     *
     * @param k  keyboard sensor.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }
    /**
     * makes one frame and put the changes on the draw surface.
     *
     * @param d the surface to draw on.
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
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
