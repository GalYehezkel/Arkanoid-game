//ID: 315786228
package geometry;
import java.util.ArrayList;
import java.util.List;
/**
 * A Rectangle that contains upperLeft Point, width and height.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    // Create a new rectangle with location and width/height.
    /**
     * constructor.
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft  upperLeft Point.
     * @param width  of the rectangle.
     * @param height  of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }
    /**
     * Returns the upper-Right point of the rectangle.
     *
     * @return Point.
     */
    public Point getUpperRight() {
        return new Point(this.upperLeft.getX() + width, this.upperLeft.getY());
    }
    /**
     * Returns the down-Right point of the rectangle.
     *
     * @return Point.
     */
    public Point getDownRight() {
        return new Point(this.upperLeft.getX() + width, this.upperLeft.getY() + height);
    }
    /**
     * Returns the down-Left point of the rectangle.
     *
     * @return Point.
     */
    public Point getDownLeft() {
        return new Point(this.upperLeft.getX(), this.upperLeft.getY() + height);
    }
    /**
     * Return a (possibly empty) List of intersection points with the specified line.
     *
     * @param line  to find intersection point with the rectangle.
     * @return java.util.List<Point>.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        Point downLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + height);
        Point upperRight = new Point(this.upperLeft.getX() + width, this.upperLeft.getY());
        Point downRight = new Point(this.upperLeft.getX() + width, this.upperLeft.getY() + height);
        Line upperLine = new Line(this.upperLeft, upperRight);
        Line rightLine = new Line(upperRight, downRight);
        Line leftLine = new Line(this.upperLeft, downLeft);
        Line downLine = new Line(downLeft, downRight);
        List<Point> ls = new ArrayList<Point>(); // list of Points.
        if (upperLine.intersectionWith(line) != null) { // if there is intersection with the upperLine.
            ls.add(upperLine.intersectionWith(line));
        }
        if (rightLine.intersectionWith(line) != null) { // if there is intersection with the rightLine.
            ls.add(rightLine.intersectionWith(line));
        }
        if (leftLine.intersectionWith(line) != null) { // if there is intersection with the leftLine.
            ls.add(leftLine.intersectionWith(line));
        }
        if (downLine.intersectionWith(line) != null) { // if there is intersection with the downLine.
            ls.add(downLine.intersectionWith(line));
        }
        return ls; // return the list.
    }
    /**
     * set upperLeft Point.
     *
     * @param upperLeft1 the new Point.
     */
    public void setUpperLeft(Point upperLeft1) {
        this.upperLeft = upperLeft1;
    }
    /**
     * Return the width of the rectangle.
     *
     * @return double.
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * Return the height of the rectangle.
     *
     * @return double.
     */
    public double getHeight() {
        return this.height;
    }
    /**
     * Returns the upper-left point of the rectangle.
     *
     * @return Point.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}