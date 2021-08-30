//ID: 315786228
package arkanoid;
import biuoop.DrawSurface;
import geometry.Epsilon;
import geometry.Line;
import geometry.Point;

import java.awt.Color;

/**
 * A ball that contains his location and radius and functions of set to his fields and move his location.
 */
public class Ball implements Sprite {
    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity v;
    private int leftBoarder;
    private int rightBoarder;
    private int upBoarder;
    private int downBoarder;
    private GameEnvironment gameEnvironment;
    private Line trajectory;

    /**
     * constructor.
     *
     * @param x     the number in x.
     * @param y     the number in y.
     * @param r     the radius.
     * @param color the color.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.radius = r;
        this.color = color;
    }
    /**
     * constructor.
     *
     * @param center the point for center.
     * @param r      the radius.
     * @param color  the color.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.radius = r;
        this.color = color;
    }

    /**
     * constructor.
     *
     * @param center          the point for center.
     * @param r               the radius.
     * @param color           the color.
     * @param gameEnvironment the game environment.
     * @param dx              the dx.
     * @param dy              the dy.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment gameEnvironment, double dx, double dy) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.gameEnvironment = gameEnvironment;
        this.v = new Velocity(dx, dy);
        this.trajectory = new Line(this.center, v.applyToPoint(this.center));
    }

    /**
     * Return the x value of this center point.
     *
     * @return int the x value.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Return the y value of this center point.
     *
     * @return int the y value.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Return the radius of the ball.
     *
     * @return int the radius of the ball.
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * Return the color of the ball.
     *
     * @return java.awt.Color the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * set the center of the ball.
     *
     * @param x to put in center.
     * @param y to put in center.
     */
    public void setCenter(int x, int y) {
        this.center = new Point(x, y);
    }

    // draw the ball on the given DrawSurface

    /**
     * draw on surface.
     *
     * @param surface the surface to draw on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.radius);
        surface.setColor(Color.black);
        surface.drawCircle(this.getX(), this.getY(), this.radius);
        surface.setColor(Color.red);
        surface.fillCircle(this.getX(), this.getY(), 2);
    }

    /**
     * notify the sprite that time has passed and make move.
     */
    public void timePassed() {
        moveOneStep();
    }
    /**
     * removes the ball from the Sprites Collection in the game.
     *
     * @param game the GameLevel.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
    /**
     * adds the Ball to the Sprites Collection in the game.
     *
     * @param g the GameLevel.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * set velocity.
     *
     * @param ve the velocity to put in v.
     */
    public void setVelocity(Velocity ve) {
        this.v = ve;
    }

    /**
     * set velocity.
     *
     * @param dx put in v.
     * @param dy to put in v.
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * retrun the velocity.
     *
     * @return Velocity the v.
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * set boarders.
     *
     * @param left  put in leftBoarder.
     * @param right to put in rightBoarder.
     * @param up    put in upBoarder.
     * @param down  to put in downBoarder.
     */
    public void setBoarders(int left, int right, int up, int down) {
        this.leftBoarder = left;
        this.rightBoarder = right;
        this.upBoarder = up;
        this.downBoarder = down;
    }

    /**
     * make a move to the ball.
     */
    public void moveOneStep() {
        this.trajectory = new Line(this.center, v.applyToPoint(this.center)); // the path of the ball.
        // gets the collision info
        CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(this.trajectory);
        if (collisionInfo == null) { // no collision, regular move.
            this.center = trajectory.end();
        } else { // move the ball almost to the collision point.
            this.center = findNewPointForCenter(collisionInfo.collisionPoint());
            this.v = collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(), this.v);
        }
    }
    /**
     * retrun the new point for the center.
     * @param colliosion point.
     * @return Point.
     */
    public Point findNewPointForCenter(Point colliosion) {
        double x = colliosion.getX(), y = colliosion.getY();
        if (this.center.getX() < colliosion.getX() + Epsilon.EPSILON) {
            x = colliosion.getX() - 1;
        } else if (this.center.getX() + Epsilon.EPSILON > colliosion.getX()) {
            x = colliosion.getX() + 1;
        } else {
            x = colliosion.getX();
        }
        if (this.center.getY() < colliosion.getY() + Epsilon.EPSILON) {
            y = colliosion.getY() - 1;
        } else if (this.center.getY() + Epsilon.EPSILON > colliosion.getY()) {
            y = colliosion.getY() + 1;
        }
        return new Point(x, y);
    }
}
