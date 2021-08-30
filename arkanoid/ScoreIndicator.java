//ID: 315786228
package arkanoid;

import arkanoidstats.Counter;
import biuoop.DrawSurface;
import geometry.Rectangle;

import java.awt.Color;
/**
 * a score indicator that displays the score.
 */
public class ScoreIndicator implements Sprite {
    private Rectangle rec;
    private Counter score;
    private String levelName;
    /**
     * constructor.
     *
     * @param rec rectangle.
     * @param score counter.
     * @param levelName the name of the level.
     */
    public ScoreIndicator(Rectangle rec, Counter score, String levelName) {
        this.rec = rec;
        this.score = score;
        this.levelName = levelName;
    }
    /**
     * draw on surface.
     *
     * @param d the surface to draw on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle((int) this.rec.getUpperLeft().getX(), (int) this.rec.getUpperLeft().getY(),
                (int) this.rec.getWidth(), (int) this.rec.getHeight());
        d.setColor(Color.BLACK);
        d.drawText((int) rec.getWidth() / 2, (int) rec.getHeight() - 3, "Score:" + score.getValue(), 20);
        d.drawText((int) rec.getWidth() / 2 + 150, (int) rec.getHeight() - 3,
                "Level Name:" + this.levelName, 20);
    }
    /**
     * adds the score to the Sprites Collection in the game.
     *
     * @param g the GameLevel.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
    /**
     * notify the sprite that time has passed.
     *
     */
    public void timePassed() {

    }
}
