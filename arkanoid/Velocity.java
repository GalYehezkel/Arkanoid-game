//ID: 315786228
package arkanoid;

import geometry.Point;

/**
 * A velocity that contains dx and dy.
 */
public class Velocity {
    private double dx, dy;
    /**
     * constructor.
     *
     * @param dx  to put in dx.
     * @param dy  to put in dy.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    /**
     * constructor- from angle and speed.
     *
     * @param angle and speed  to put in dx.
     * @param speed and angle  to put in dy.
     * @return Velocity to the user.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double rad = Math.toRadians(angle - 90);
        double dx = speed * Math.cos(rad);
        double dy = speed * Math.sin(rad);
        return new Velocity(dx, dy);
    }
    /**
     * Return the dx value of this velocity.
     *
     * @return double the dx value.
     */
    public double getDx() {
        return this.dx;
    }
    /**
     * Return the dy value of this velocity.
     *
     * @return double the dy value.
     */
    public double getDy() {
        return this.dy;
    }
    // Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)
    /**
     * Take a point with position (x,y) and return a new point.
     *     with position (x+dx, y+dy)
     *
     * @param p point to add dx and dy.
     * @return point with the new position.
     */
    public Point applyToPoint(Point p) {
        Point temp = new Point(p.getX() + this.dx, p.getY() + this.dy);
        return temp;
    }
}
