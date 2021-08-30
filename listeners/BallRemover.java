//ID: 315786228
package listeners;

import arkanoid.Ball;
import arkanoid.Block;
import arkanoid.GameLevel;
import arkanoidstats.Counter;
/**
 *  a BallRemover is in charge of removing balls from the game, as well as keeping count
 *  of the number of balls that remain.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;
    /**
     * constructor.
     *
     * @param game  to put in game.
     * @param removedBalls  to put in remaining balls.
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }
    /**
     * ball that hits the block should be removed
     * from the game.
     * @param beingHit the block.
     * @param hitter the ball who hits.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
          remainingBalls.decrease(1);
          hitter.removeFromGame(game);
    }
}
