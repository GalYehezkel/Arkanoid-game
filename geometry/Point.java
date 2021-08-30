//ID: 315786228
package geometry;
/**
 * Represents a point that contains x and y.
 */
public class Point {
    private double x;
    private double y;
    /**
     * constructor.
     *
     * @param x  the number in x.
     * @param y  the number in y.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * distance -- return the distance of this point to the other point.
     *
     * @param other the other point.
     * @return double the distance between the two points.
     */
    public double distance(Point other) {
        return Math.sqrt(((this.x - other.getX()) * (this.x - other.getX()))
                + ((this.y - other.getY()) * (this.y - other.getY())));
    }
    /**
     * equals -- return true is the points are equal, false otherwise.
     *
     * @param other the other point.
     * @return boolean true if equals, else false.
     */
    public boolean equals(Point other) {
        return Math.abs(this.x - other.getX()) < Epsilon.EPSILON && Math.abs(this.y - other.getY()) < Epsilon.EPSILON;
    }
    /**
     * equalsInInt -- return true is the points are equal in int, false otherwise.
     *
     * @param other the other point.
     * @return boolean true if equals, else false.
     */
    public boolean equalsInInt(Point other) {
        return ((int) this.x == (int) other.getX()) && ((int) this.y == (int) other.getY());
    }
    /**
     * Return the x value of this point.
     *
     * @return double the x value.
     */
    public double getX() {
        return this.x;
    }
    /**
     * Return the y value of this point.
     *
     * @return double the y value.
     */
    public double getY() {
        return this.y;
    }
}
