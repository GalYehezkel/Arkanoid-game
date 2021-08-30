//ID: 315786228
package listeners;

import arkanoid.Ball;
import arkanoid.Block;
import arkanoidstats.Counter;
/**
 * a score tracking listener that updates the score after each hit by increasing 5 points.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;
    /**
     * constructor.
     *
     * @param scoreCounter  to put in currentScore.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * increase the score by 5 points.
     * @param beingHit the block.
     * @param hitter the ball who hits.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
       currentScore.increase(5);
    }
}
