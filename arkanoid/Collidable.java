//ID: 315786228
package arkanoid;

import geometry.Point;
import geometry.Rectangle;

/**
 * A collidable interface.
 */
public interface Collidable {
    /**
     * Return the "collision shape" of the object.
     *
     * @return Rectangle.
     */
    Rectangle getCollisionRectangle();
    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit (based on the force the object inflicted on us).
     *
     * @param collisionPoint the collision point.
     * @param currentVelocity the current velocity.
     * @param hitter the ball that hits the collidable.
     * @return velocity.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}