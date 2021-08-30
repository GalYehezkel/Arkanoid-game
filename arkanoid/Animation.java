//ID: 315786228
package arkanoid;

import biuoop.DrawSurface;
/**
 * An Animation interface.
 */
public interface Animation {
    /**
     * makes one frame and put the changes on the draw surface.
     *
     * @param d the surface to draw on.
     */
    void doOneFrame(DrawSurface d);
    /**
     * checks if need to stop.
     *
     * @return boolean indicates if need to stop.
     */
    boolean shouldStop();
}
