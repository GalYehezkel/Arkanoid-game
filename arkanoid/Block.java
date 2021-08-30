//ID: 315786228
package arkanoid;
import biuoop.DrawSurface;
import geometry.Epsilon;
import geometry.Point;
import geometry.Rectangle;
import listeners.HitListener;
import listeners.HitNotifier;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A block that contains a rectangle and a color, implements Collidable, Sprite, HitNotifier.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rec;
    private java.awt.Color color;
    private List<HitListener> hitListeners;
    /**
     * constructor.
     *
     * @param rec  rectangle.
     * @param color  color to the block.
     */
    public Block(Rectangle rec, java.awt.Color color) {
        this.rec = rec;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }
    /**
     * Return the "collision shape" of the object.
     *
     * @return rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rec;
    }
    /**
     * draw on surface.
     *
     * @param surface the surface to draw on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);
        surface.fillRectangle((int) this.rec.getUpperLeft().getX(), (int) this.rec.getUpperLeft().getY(),
                (int) this.rec.getWidth(), (int) this.rec.getHeight());
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) this.rec.getUpperLeft().getX(), (int) this.rec.getUpperLeft().getY(),
                (int) this.rec.getWidth(), (int) this.rec.getHeight());
    }
    /**
     * notify the sprite that time has passed.
     *
     */
    public void timePassed() {
    }
    /**
     * adds the Block to the Sprites Collection in the game and to the Collidables collection in the game.
     *
     * @param g the GameLevel.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
    /**
     * removes the Block from the Sprites Collection in the game and from the Collidables collection in the game.
     *
     * @param game the GameLevel.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }
    /**
     * notify all the listeners on the hit.
     * @param hitter the ball that hits the block.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit (based on the force the object inflicted on us).
     *
     * @param collisionPoint the collision point.
     * @param currentVelocity the current velocity.
     * @param hitter the ball that hits the block.
     * @return velocity.
     */
     public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
         Point upperLeft = this.rec.getUpperLeft();
         Point upperRight = this.rec.getUpperRight();
         Point downLeft = this.rec.getDownLeft();
         Point downRight = this.rec.getDownRight();
         if ((collisionPoint.equalsInInt(upperLeft)) || (collisionPoint.equalsInInt(upperRight)
                 || (collisionPoint.equalsInInt(downLeft) || (collisionPoint.equalsInInt(downRight))))) {
             if ((collisionPoint.equalsInInt(upperLeft))) { //upleft
                 if (currentVelocity.getDx() > 0 && currentVelocity.getDy() > 0) {
                     Velocity save = new Velocity(currentVelocity.getDx() * (-1),
                             currentVelocity.getDy() * (-1));
                     this.notifyHit(hitter);
                     return save;
                 } else if (currentVelocity.getDx() > 0 && currentVelocity.getDy() < 0) {
                     Velocity save = new Velocity(currentVelocity.getDx() * (-1),
                             currentVelocity.getDy());
                     this.notifyHit(hitter);
                     return save;
                 } else {
                     Velocity save = new Velocity(currentVelocity.getDx(),
                             currentVelocity.getDy() * (-1));
                     this.notifyHit(hitter);
                     return save;
                 }
             } else if ((collisionPoint.equalsInInt(downLeft))) { //donwleft
                 if (currentVelocity.getDx() > 0 && currentVelocity.getDy() < 0) {
                     Velocity save = new Velocity(currentVelocity.getDx() * (-1),
                             currentVelocity.getDy() * (-1));
                     this.notifyHit(hitter);
                     return save;
                 } else if (currentVelocity.getDx() > 0 && currentVelocity.getDy() > 0) {
                     Velocity save = new Velocity(currentVelocity.getDx() * (-1),
                             currentVelocity.getDy());
                     this.notifyHit(hitter);
                     return save;
                 } else {
                     Velocity save = new Velocity(currentVelocity.getDx(),
                             currentVelocity.getDy() * (-1));
                     this.notifyHit(hitter);
                     return save;
                 }
             } else if ((collisionPoint.equalsInInt(downRight))) { //downright
                 if (currentVelocity.getDx() < 0 && currentVelocity.getDy() < 0) {
                     Velocity save = new Velocity(currentVelocity.getDx() * (-1),
                             currentVelocity.getDy() * (-1));
                     this.notifyHit(hitter);
                     return save;
                 } else if (currentVelocity.getDx() < 0 && currentVelocity.getDy() > 0) {
                     Velocity save = new Velocity(currentVelocity.getDx() * (-1),
                             currentVelocity.getDy());
                     this.notifyHit(hitter);
                     return save;
                 } else {
                     Velocity save = new Velocity(currentVelocity.getDx(),
                             currentVelocity.getDy() * (-1));
                     this.notifyHit(hitter);
                     return save;
                 }
             } else {  //upright
                 if (currentVelocity.getDx() < 0 && currentVelocity.getDy() > 0) {
                     Velocity save = new Velocity(currentVelocity.getDx() * (-1),
                             currentVelocity.getDy() * (-1));
                     this.notifyHit(hitter);
                     return save;
                 } else if (currentVelocity.getDx() < 0 && currentVelocity.getDy() < 0) {
                     Velocity save = new Velocity(currentVelocity.getDx() * (-1),
                             currentVelocity.getDy());
                     this.notifyHit(hitter);
                     return save;
                 } else {
                     Velocity save = new Velocity(currentVelocity.getDx(),
                             currentVelocity.getDy() * (-1));
                     this.notifyHit(hitter);
                     return save;
                 }
             }
             // if hits the edges.
         } else if (Math.abs(collisionPoint.getX() - rec.getUpperLeft().getX()) < Epsilon.EPSILON
                ||  Math.abs((collisionPoint.getX() - rec.getUpperLeft().getX() - rec.getWidth())) < Epsilon.EPSILON) {
            Velocity save = new Velocity(currentVelocity.getDx() * (-1), currentVelocity.getDy());
             this.notifyHit(hitter);
            return save;
        } else { // hits the top or down of the block.
            Velocity save = new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * (-1));
             this.notifyHit(hitter);
            return save;
        }
     }
    /**
     * Add hl as a listener to hit listener list.
     * @param hl the hit listener to add.
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }
    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl the hit listener to remove.
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
