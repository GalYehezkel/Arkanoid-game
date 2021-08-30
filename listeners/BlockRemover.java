//ID: 315786228
package listeners;

import arkanoid.Ball;
import arkanoid.Block;
import arkanoid.GameLevel;
import arkanoidstats.Counter;

/**
 *  a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 *  of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;
    /**
     * constructor.
     *
     * @param game  to put in game.
     * @param removedBlocks  to put in remainingBlocks.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }
    /**
     * Blocks that are hit should be removed
     * from the game. Remember to remove this listener from the block
     * that is being removed from the game.
     * @param beingHit the block.
     * @param hitter the ball who hits.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBlocks.decrease(1);
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(game);
    }
}
