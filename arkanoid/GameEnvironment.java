//ID: 315786228
package arkanoid;
import geometry.Line;
import geometry.Point;

import java.util.ArrayList;
import java.util.List;
/**
 * game environment that contains a collidable list and finds collisions with them and the balls.
 *
 */
public class GameEnvironment {
    private List<Collidable> collidables;
    /**
     * constructor.
     *
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }
    /**
     * adds collidable to the collidable list.
     *
     * @param c the collidable to add.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }
    /**
     * removes collidable from the collidable list.
     *
     * @param c the collidable to remove.
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }
    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables in this collection,
     * return null. Else, return the information about the closest collision that is going to occur.
     * @param trajectory the trajectory line.
     * @return CollisionInfo.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        CollisionInfo save; // the collisionInfo the will return.
        Point collisionPoint; // collision point.
        List<CollisionInfo> collisionInfos = new ArrayList<CollisionInfo>(); // list of collisionInfos.
        for (Collidable c : collidables) { //find all collisions with the collidables list.
            collisionPoint = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            if (collisionPoint != null) { //there is collision.
                collisionInfos.add(new CollisionInfo(collisionPoint, c)); // add collisionInfo to the list.
            }
        }
        if (collisionInfos.isEmpty()) { // if list is empty, returns null.
            return null;
        } else { //there is collisions.
            double minDistance = trajectory.start().distance(collisionInfos.get(0).collisionPoint());
            save = collisionInfos.get(0); // save first collisionInfo in the list.
            for (CollisionInfo c : collisionInfos) { // find if there is a closer collision.
                if (trajectory.start().distance(c.collisionPoint()) < minDistance) {
                    minDistance = trajectory.start().distance(c.collisionPoint());
                    save = c;
                }
            }
            return save;
        }
    }
}