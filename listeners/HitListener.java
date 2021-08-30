//ID: 315786228
package listeners;

import arkanoid.Ball;
import arkanoid.Block;
/**
 * interface of Hit Listener.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit the block.
     * @param hitter the ball who hits.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
