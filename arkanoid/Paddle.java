//ID: 315786228
package arkanoid;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import geometry.Epsilon;
import geometry.Point;
import geometry.Rectangle;

import java.awt.Color;
/**
 * A paddle the contains a rectangle, color and keyboard sensor.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rec;
    private java.awt.Color color;
    private int width = 800, height = 600, heightOfBlock = 10,
            widthOfPeddal = 70, heightOfPeddal = 10, speed;
    /**
     * constructor.
     *
     * @param rec  rectangle.
     * @param color  color to the block.
     * @param keyboard  keyboard sensor.
     * @param widthOfPeddal  width of paddle.
     * @param speed  speed of paddle.
     */
    public Paddle(Rectangle rec, biuoop.KeyboardSensor keyboard,  java.awt.Color color, int widthOfPeddal, int speed) {
        this.rec = rec;
        this.keyboard = keyboard;
        this.color = color;
        this.widthOfPeddal = widthOfPeddal;
        this.speed = speed;
    }
    /**
     * move the paddle left.
     *
     */
    public void moveLeft() {
        if (rec.getUpperLeft().getX() > heightOfBlock + speed) { // if bigger then the edge of the left boarder.
            rec.setUpperLeft(new Point(rec.getUpperLeft().getX() - speed, rec.getUpperLeft().getY()));
        } else if (rec.getUpperLeft().getX() > heightOfBlock) {
            rec.setUpperLeft(new Point(heightOfBlock + 1, rec.getUpperLeft().getY()));
        }
    }
    /**
     * move the paddle right.
     *
     */
    public void moveRight() {
        //if smaller then the left boarder.
        if (rec.getUpperLeft().getX() < width - widthOfPeddal - heightOfBlock - 1 - speed) {
            rec.setUpperLeft(new Point(rec.getUpperLeft().getX() + speed, rec.getUpperLeft().getY()));
        } else if ((rec.getUpperLeft().getX() < width - widthOfPeddal - heightOfBlock - 1)) {
            rec.setUpperLeft(new Point(width - heightOfBlock - widthOfPeddal, rec.getUpperLeft().getY()));
        }
    }
    /**
     * notify the sprite that time has passed and check if go left or right.
     *
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        } else if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
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
     * Return the "collision shape" of the object.
     *
     * @return rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rec;
    }
    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit.
     * divide the paddle to 5 regions equal:
     * region 1 - 300 degrees, region 2 - 330 degrees, region 3 - like regular block
     * region 4 - 30 degrees and region 5 - 60 degrees.
     *
     * @param collisionPoint the collision point.
     * @param currentVelocity the current velocity.
     * @param hitter ball that hits the paddle.
     * @return velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        int sizeOfRegion = (widthOfPeddal / 5); // divide to equal regions.
        Point upperLeft = this.rec.getUpperLeft();
        Point upperRight = this.rec.getUpperRight();
        if ((collisionPoint.equalsInInt(upperLeft)) || (collisionPoint.equalsInInt(upperRight))) {
            if (currentVelocity.getDx() > 0 && currentVelocity.getDy() > 0
                    && (collisionPoint.equalsInInt(upperLeft))) { //up left
                Velocity save = new Velocity(currentVelocity.getDx() * (-1),
                        currentVelocity.getDy() * (-1));
                return save;
            } else if (currentVelocity.getDx() < 0 && currentVelocity.getDy() > 0
                    && (collisionPoint.equalsInInt(upperRight))) {  //upright
                Velocity save = new Velocity(currentVelocity.getDx() * (-1), currentVelocity.getDy() * (-1));
                return save;
            } else if (collisionPoint.equalsInInt(upperRight)) { //region 5.
                return Velocity.fromAngleAndSpeed(60, 3);
            } else { //region 1.
                return Velocity.fromAngleAndSpeed(300, 3);
            }
        } else if (Math.abs(collisionPoint.getX() - rec.getUpperLeft().getX()) < Epsilon.EPSILON
                ||  Math.abs((collisionPoint.getX() - rec.getUpperLeft().getX() - rec.getWidth())) < Epsilon.EPSILON) {
            Velocity save = new Velocity(currentVelocity.getDx() * (-1), currentVelocity.getDy());
            return save;
        } else { // hits the top of the paddle.
            if (rec.getUpperLeft().getX() <= collisionPoint.getX() + Epsilon.EPSILON // region 1.
                    && rec.getUpperLeft().getX() + sizeOfRegion + Epsilon.EPSILON >= collisionPoint.getX()) {
                return Velocity.fromAngleAndSpeed(300, 3);
            } else if (rec.getUpperLeft().getX() + sizeOfRegion <= collisionPoint.getX() + Epsilon.EPSILON // region 2.
                    && rec.getUpperLeft().getX() + 2 * sizeOfRegion + Epsilon.EPSILON >= collisionPoint.getX()) {
                return Velocity.fromAngleAndSpeed(330, 3);
                // region 4.
            } else if (rec.getUpperLeft().getX() + 3 * sizeOfRegion <= collisionPoint.getX()  + Epsilon.EPSILON
                    && rec.getUpperLeft().getX() + 4 * sizeOfRegion + Epsilon.EPSILON >= collisionPoint.getX()) {
                return Velocity.fromAngleAndSpeed(30, 3);
                // region 5.
            } else if (rec.getUpperLeft().getX() + 4 * sizeOfRegion <= collisionPoint.getX() + Epsilon.EPSILON
                    && rec.getUpperLeft().getX() + 5 * sizeOfRegion + Epsilon.EPSILON >= collisionPoint.getX()) {
                return Velocity.fromAngleAndSpeed(60, 3);
            } // region 3.
            Velocity save = new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * (-1));
            return save;
        }

    }
    /**
     * adds the Paddle to the Sprites Collection in the game and to the Collidables collection in the game.
     *
     * @param g the GameLevel.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}