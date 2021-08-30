//ID: 315786228
package arkanoid;

import geometry.Point;

/**
 * collision info that contains collision point and collision object.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;
    /**
     * constructor.
     *
     * @param collisionPoint  collision Point.
     * @param collisionObject  collision Object.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }
    /**
     * Return the point at which the collision occurs.
     *
     * @return Point.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }
    /**
     * Return the collidable object involved in the collision.
     *
     * @return Collidable.
     */
    public Collidable collisionObject() {
        return this.collisionObject;

    }
}