//ID: 315786228
package geometry;
import  java.util.List;
/**
 * Represents a line that contains two points one start and one end.
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * constructor.
     *
     * @param start  the point in start.
     * @param end  the point in end.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
    /**
     * constructor.
     *
     * @param x1  the x of first point.
     * @param y1  the y of first point.
     * @param x2  the x of first point.
     * @param y2  the y of first point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }
    /**
     * Return the length of the line.
     *
     * @return double the length of the line.
     */
    public double length() {
        return this.start.distance(this.end);
    }
    /**
     * Returns the middle point of the line.
     *
     * @return point of the middle of the line.
     */
    public Point middle() {
        Point middle = new Point((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
        return middle;
    }
    /**
     * Returns the start point of the line.
     *
     * @return point of the start of the line.
     */
    // Returns the start point of the line
    public Point start() {
        return this.start;
    }
    /**
     *  Returns the end point of the line.
     *
     * @return point of the end of the line.
     */
    // Returns the end point of the line
    public Point end() {
        return this.end;
    }
    /**
     *  calculate the incline of the line.
     *
     * @param other the other line.
     * @return double incline of the line.
     */
    public double calculateIncline(Line other) {
        double x1 = other.start().getX(), y1 = other.start().getY(), x2 = other.end().getX(), y2 = other.end().getY();
        if (Math.abs(x1 - x2) < Epsilon.EPSILON) {
            return Double.POSITIVE_INFINITY;
        } else {
            return (y2 - y1) / (x2 - x1);
        }
    }
    /**
     *  checks if a point is in the line.
     *
     * @param other the other line.
     * @param checkIn the line that is checked if the point is in it.
     * @param incline the incline of checkIn.
     * @return boolean true if the point is in the line, else false.
     */
    public boolean isInLine(Point other, Line checkIn, double incline) {
        return Math.abs(other.getY() - (incline * (other.getX() - checkIn.start().getX()) + checkIn.start().getY()))
                < Epsilon.EPSILON;
    }
    /**
     *  checks if a point x is between Maxx and Minx.
     *
     * @param other the point.
     * @param maxLineOtherX the maxX.
     * @param minLineOtherX the mixX.
     * @return boolean true if the point x is between Maxx and Minx, else false.
     */
    public boolean isInRangeX(Point other, double maxLineOtherX, double minLineOtherX) {
        return other.getX() <= maxLineOtherX + Epsilon.EPSILON && other.getX() + Epsilon.EPSILON >= minLineOtherX;
    }
    /**
     *  checks if a point y is between Maxy and Miny.
     *
     * @param other the point.
     * @param maxLineOtherY the maxY.
     * @param minLineOtherY the mixY.
     * @return boolean true if the point y is between Maxy and Miny, else false.
     */
    public boolean isInRangeY(Point other, double maxLineOtherY, double minLineOtherY) {
        return other.getY() <= maxLineOtherY + Epsilon.EPSILON && other.getY() + Epsilon.EPSILON >= minLineOtherY;
    }
    /**
     *  Returns true if the lines intersect, false otherwise.
     *
     * @param other the line.
     * @return boolean true if the lines is intersecting, else false.
     */
    public boolean isIntersecting(Line other) {
        double x1 = this.start.getX(), y1 = this.start.getY(), x2 = this.end.getX(), y2 = this.end.getY(),
                x3 = other.start().getX(), y3 = other.start().getY(), x4 = other.end().getX(), y4 = other.end().getY();
        double maxLineCurrentX = Math.max(x1, x2), maxLineCurrentY = Math.max(y1, y2),
                minLineCurrentX = Math.min(x1, x2),
                minLineCurrentY = Math.min(y1, y2), maxLineOtherX = Math.max(x3, x4), maxLineOtherY = Math.max(y3, y4),
                minLineOtherX = Math.min(x3, x4), minLineOtherY = Math.min(y3, y4);
        double inclineCurrent = calculateIncline(this);
        double inclineOther = calculateIncline(other);
        if (Math.abs(inclineCurrent - inclineOther) < Epsilon.EPSILON) { //if inclines equals.
            //if the two lines are both verticals.
            if (inclineCurrent == Double.POSITIVE_INFINITY && inclineOther == Double.POSITIVE_INFINITY) {
                if (!(Math.abs(x1 - x3) < Epsilon.EPSILON)) { //if the x vertical is different.
                    return false;
                } else if (this.start.equals(other.start())) { //checks if the is only one intersecting.
                    if (this.end.equals(other.end())) {
                        return false;
                    } else {
                        return (!isInRangeY(this.end, maxLineOtherY, minLineOtherY)
                                && !isInRangeY(other.end(), maxLineCurrentY, minLineCurrentY));
                    }
                } else if (this.start.equals(other.end())) {
                    if (this.end.equals(other.start())) {
                        return false;
                    } else {
                        return (!isInRangeY(this.end, maxLineOtherY, minLineOtherY)
                                && !isInRangeY(other.start(), maxLineCurrentY, minLineCurrentY));
                    }
                } else if (this.end.equals(other.start())) {
                    if (this.start.equals(other.end())) {
                        return false;
                    } else {
                        return (!isInRangeY(this.start, maxLineOtherY, minLineOtherY)
                                && !isInRangeY(other.end(), maxLineCurrentY, minLineCurrentY));
                    }
                } else if (this.end.equals(other.end())) {
                    if (this.start.equals(other.start())) {
                        return false;
                    } else {
                        return (!isInRangeY(this.start, maxLineOtherY, minLineOtherY)
                                && !isInRangeY(other.start(), maxLineCurrentY, minLineCurrentY));
                    }
                }
            } else if (this.start.equals(other.start())) { //the lines are not verticals.
                if (this.end.equals(other.end())) { //checks if the two parallel lines has only one intersection.
                    return false;
                } else {
                    return (!isInRangeX(this.end, maxLineOtherX, minLineOtherX)
                            && !isInRangeX(other.end(), maxLineCurrentX, minLineCurrentX));
                }
            } else if (this.start.equals(other.end())) {
                if (this.end.equals(other.start())) {
                    return false;
                } else {
                    return (!isInRangeX(this.end, maxLineOtherX, minLineOtherX)
                            && !isInRangeX(other.start(), maxLineCurrentX, minLineCurrentX));
                }
            } else if (this.end.equals(other.start())) {
                if (this.start.equals(other.end())) {
                    return false;
                } else {
                    return (!isInRangeX(this.start, maxLineOtherX, minLineOtherX)
                            && !isInRangeX(other.end(), maxLineCurrentX, minLineCurrentX));
                }
            } else if (this.end.equals(other.end())) {
                if (this.start.equals(other.start())) {
                    return false;
                } else {
                    return (!isInRangeX(this.start, maxLineOtherX, minLineOtherX)
                            && !isInRangeX(other.start(), maxLineCurrentX, minLineCurrentX));
                }
            }
        } else { //if inclines not equal, checks if there is intersection between the two lines.
            if (inclineCurrent == Double.POSITIVE_INFINITY || inclineOther == Double.POSITIVE_INFINITY) {
                if (inclineCurrent == Double.POSITIVE_INFINITY) {
                    double holderOther = other.start().getX() * (-inclineOther) + other.start().getY();
                    double resultX = this.start.getX();
                    double resultY = holderOther + inclineOther * resultX;
                    return (resultY + Epsilon.EPSILON >= minLineCurrentY
                            && resultY <= maxLineCurrentY + Epsilon.EPSILON)
                            && (minLineOtherX <= resultX + Epsilon.EPSILON
                            && maxLineOtherX + Epsilon.EPSILON >= resultX);
                } else {
                double holderCurrent = this.start.getX() * (-inclineCurrent) + this.start.getY();
                double resultX = other.start().getX();
                double resultY = holderCurrent + inclineCurrent * resultX;
                return (resultY + Epsilon.EPSILON >= minLineOtherY && resultY <= maxLineOtherY + Epsilon.EPSILON)
                        && (minLineCurrentX <= resultX + Epsilon.EPSILON
                        && maxLineCurrentX + Epsilon.EPSILON >= resultX);
                }
            } else {
                double holderCurrent = this.start.getX() * (-inclineCurrent) + this.start.getY();
                double holderOther = other.start().getX() * (-inclineOther) + other.start().getY();
                double resultX = (holderCurrent - holderOther) / (inclineOther - inclineCurrent);
                double resultY = holderCurrent + inclineCurrent * resultX;
                Point result = new Point(resultX, resultY);
                if (isInRangeX(result, maxLineOtherX, minLineOtherX) && isInRangeY(result, maxLineOtherY, minLineOtherY)
                        && isInRangeX(result, maxLineCurrentX, minLineCurrentX)
                        && isInRangeY(result, maxLineCurrentY, minLineCurrentY)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    // Returns the intersection point if the lines intersect,
    // and null otherwise.
    /**
     *  Returns true the intersection point between two lines.
     *
     * @param other the line.
     * @return the intersection point between two lines.
     */
    public Point intersectionWith(Line other) {
        boolean flag = isIntersecting(other);
        double inclineCurrent = calculateIncline(this);
        double inclineOther = calculateIncline(other);
        if (flag) { //if there is intersection.
            if (Math.abs(inclineCurrent - inclineOther) < Epsilon.EPSILON) { //if inclines equal.
                if (this.start.equals(other.start()) || this.start.equals(other.end())) {
                    return this.start;
                } else if (this.end.equals(other.start()) || this.end.equals(other.end())) {
                    return this.end;
                }
            } else { //inclines not equal.
                if (inclineCurrent == Double.POSITIVE_INFINITY || inclineOther == Double.POSITIVE_INFINITY) {
                    if (inclineCurrent == Double.POSITIVE_INFINITY) {
                        double holderOther = other.start().getX() * (-inclineOther) + other.start().getY();
                        double resultX = this.start.getX();
                        double resultY = holderOther + inclineOther * resultX;
                        Point result = new Point(resultX, resultY);
                        return result;
                    } else {
                        double holderCurrent = this.start.getX() * (-inclineCurrent) + this.start.getY();
                        double resultX = other.start().getX();
                        double resultY = holderCurrent + inclineCurrent * resultX;
                        Point result = new Point(resultX, resultY);
                        return result;
                    }
                }
                double holderCurrent = this.start.getX() * (-inclineCurrent) + this.start.getY();
                double holderOther = other.start().getX() * (-inclineOther) + other.start().getY();
                double resultX = (holderCurrent - holderOther) / (inclineOther - inclineCurrent);
                double resultY = holderCurrent + inclineCurrent * resultX;
                Point result = new Point(resultX, resultY);
                return result;
            }
        }
        return null; //there is not intersection.
    }
    /**
     *  equals -- return true is the lines are equal, false otherwise.
     *
     * @param other the line.
     * @return boolean return true is lines equal, else false.
     */
    public boolean equals(Line other) {
        return (this.start.equals(other.start()) && (this.end.equals(other.end())));
    }
    // If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.
    /**
     *  If this line does not intersect with the rectangle, return null.
     *  Otherwise, return the closest intersection point to the start of the line.
     *
     * @param rect the rectangle.
     * @return Point.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> ls = rect.intersectionPoints(this);
        if (ls.isEmpty()) {
            return null;
        } else {
            double minDistance = this.start.distance(ls.get(0));
            Point save = ls.get(0);
            for (Point p : ls) {
                if (this.start.distance(p) < minDistance + Epsilon.EPSILON) {
                    minDistance = this.start.distance(p);
                    save = p;
                }
            }
            return save;
        }

    }
}

