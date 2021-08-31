//ID: 315786228
package arkanoid;
import levels.LevelInformation;
import arkanoidstats.Counter;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import geometry.Point;
import geometry.Rectangle;
import listeners.BallRemover;
import listeners.BlockRemover;
import listeners.ScoreTrackingListener;

import java.awt.Color;
import java.util.List;

/**
 * A game level that contains a sprite collection, environment, GUI, colors array and sleeper.
 * runs a game that displays blocks pedals and balls.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private int width = 800, height = 600, heightOfBlock = 10,
            widthOfPeddal, heightOfPeddal = 10, amountOfBalls;
    private int heightOfScore = 20;
    private Counter countBlocks, countBalls, score;
    private AnimationRunner runner;
    private boolean running;
    private biuoop.KeyboardSensor keyboard;
    private double numOfSeconds = 3;
    private int countFrom = 3;
    private LevelInformation levelInformation;
    private int speedOfPeddal;
    /**
     * constructor.
     * @param levelInformation the level information.
     * @param ar the animation runner.
     * @param ks the keyboard sensor.
     * @param score the score counter.
     */
    public GameLevel(LevelInformation levelInformation, AnimationRunner ar, KeyboardSensor ks, Counter score) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        countBlocks = new Counter();
        countBalls = new Counter();
        //new game level
        this.levelInformation = levelInformation;
        this.keyboard = ks;
        this.runner = ar;
        this.score = score;
    }
    /**
     * returns the number of blocks remained.
     *
     * @return int number of block remained.
     */
    public int numOfBlocksRemain() {
        return this.countBlocks.getValue();
    }
    /**
     * returns the number of balls remained.
     *
     * @return int number of balls remained.
     */
    public int numOfBallsRemain() {
        return this.countBalls.getValue();
    }
    /**
     * checks if need to stop, true for stop.
     *
     * @return boolean indicates if need to stop.
     */
    public boolean shouldStop() {
        return !this.running;
    }
    /**
     * makes one frame and put the changes on the draw surface.
     *
     * @param d the surface to draw on.
     */
    public void doOneFrame(DrawSurface d) {
        // the logic from the previous run method goes here.
        // the `return` or `break` statements should be replaced with
        // this.running = false;
        if (countBlocks.getValue() == 0 || countBalls.getValue() == 0) { // if out of balls or blocks.
            if (countBlocks.getValue() == 0) { // if out of blocks.
                score.increase(100);
            }
            this.running = false;
        }
        if (this.running) {
            if (this.keyboard.isPressed("p")) {
                this.runner.run(new KeyPressStoppableAnimation(keyboard, KeyboardSensor.SPACE_KEY,
                        new PauseScreen(keyboard)));
            }
            this.sprites.drawAllOn(d);
            this.sprites.notifyAllTimePassed();
        }
    }
    /**
     * adds collidable to the environment.
     *
     * @param c the collidable to add.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }
    /**
     * adds sprite to the sprites collection.
     *
     * @param s the sprite to add.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }
    /**
     * remove collidable from the environment.
     *
     * @param c the collidable to remove.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }
    /**
     * remove sprite from the sprites collection.
     *
     * @param s the sprite to remove.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }
    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     *
     */
    public void initialize() {
        this.widthOfPeddal = this.levelInformation.paddleWidth();
        this.speedOfPeddal = this.levelInformation.paddleSpeed();
        this.amountOfBalls = this.levelInformation.numberOfBalls();
        List<Velocity> ls = this.levelInformation.initialBallVelocities();
        List<Block> blocks = this.levelInformation.blocks();
        this.addSprite(this.levelInformation.getBackground());
        BlockRemover blockRemover = new BlockRemover(this, countBlocks);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(score);
        for (Block b : blocks) {
            b.addToGame(this);
            b.addHitListener(blockRemover);
            b.addHitListener(scoreTrackingListener);
            countBlocks.increase(1);
        }
        for (int i = 0; i < amountOfBalls; i++) {
            Ball ball = new Ball(new Point(width / 2 + 10, height - heightOfBlock - heightOfPeddal - 30), 4,
                    Color.white, environment, ls.get(i).getDx(), ls.get(i).getDy());
            ball.addToGame(this);
            countBalls.increase(1);
        }
        // create blocks for the borders.
        Block block = new Block(new Rectangle(new Point(1, heightOfScore), width, heightOfBlock), Color.GRAY);
        block.addToGame(this);
        block = new Block(new Rectangle(new Point(1, heightOfBlock + heightOfScore),
                heightOfBlock, height - heightOfBlock - heightOfScore), Color.GRAY);
        block.addToGame(this);
        block = new Block(new Rectangle(new Point(heightOfBlock + 1, height - 1), // death region.
                width - 2 * heightOfBlock - 1, 1), Color.GRAY);
        block.addToGame(this);
        BallRemover ballRemover = new BallRemover(this, countBalls);
        block.addHitListener(ballRemover);
        block = new Block(new Rectangle(new Point(width - heightOfBlock, heightOfBlock + heightOfScore),
                heightOfBlock, height - heightOfBlock - heightOfScore), Color.GRAY);
        block.addToGame(this);
        //create paddle and add it to the game.
        Paddle paddle = new Paddle(new Rectangle(new Point(width / 2 - widthOfPeddal / 2,
                height - heightOfBlock - heightOfPeddal - 1),
                widthOfPeddal, heightOfPeddal), keyboard, Color.orange, this.widthOfPeddal, this.speedOfPeddal);
        paddle.addToGame(this);
        ScoreIndicator scoreIndicator = new ScoreIndicator((new Rectangle(new Point(1, 1),
                width, heightOfScore)), this.score, this.levelInformation.levelName());
        scoreIndicator.addToGame(this);
    }
    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        // countdown before turn starts.
        this.runner.run(new CountdownAnimation(this.numOfSeconds, this.countFrom, this.sprites));
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.running = true;
        this.runner.run(this);
    }
}