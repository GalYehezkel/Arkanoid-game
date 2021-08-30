//ID: 315786228
package arkanoid;
import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;
/**
 * A Sprite Collection that contains a list of sprites.
 */
public class SpriteCollection {
    private List<Sprite> sprites;
    /**
     * constructor.
     *
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>();
    }
    /**
     * adds sprite to the sprites collection.
     *
     * @param s the sprite to add.
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }
    /**
     * removes sprite from the sprites collection.
     *
     * @param s the sprite to remove.
     */
    public void removeSprite(Sprite s) {
        sprites.remove(s);
    }
    /**
     * call timePassed() on all sprites.
     *
     */
    public void notifyAllTimePassed() {
        // Make a copy of the spriteCollection before iterating over them.
        List<Sprite> spritesCopy = new ArrayList<Sprite>(this.sprites);
        for (Sprite s : spritesCopy) {
            s.timePassed();
        }
    }
    /**
     * call drawOn(d) on all sprites.
     *
     * @param d the surface to draw on.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }
}