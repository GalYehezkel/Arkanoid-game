//ID: 315786228
package arkanoid;
import biuoop.DrawSurface;
/**
 * interface of Sprite.
 */
public interface Sprite {
    /**
     * draw on surface.
     *
     * @param d the surface to draw on.
     */
    void drawOn(DrawSurface d);
    /**
     * notify the sprite that time has passed.
     *
     */
    void timePassed();
}