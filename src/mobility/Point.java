/**
 *
 * @author Yair davidoff 314792714 nehoray hajaj 208090738
 */
package mobility;

public class Point {
    private int x;
    private int y;
    private int max_x = 800;
    private int min_x;
    private int min_y = 0;
    private int max_y = 600;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point location) {
        this.x = location.x;
        this.y = location.y;
    }

    public int get_x() {
        return this.x;
    }

    public int get_y() {
        return this.y;
    }

    public int get_max_x() {
        return this.max_x;
    }

    public int get_min_x() {
        return this.min_x;
    }

    public int get_max_y() {
        return this.max_y;
    }

    public int get_min_y() {
        return this.min_y;
    }

    public static boolean chackBoundaris(Point point) {
        return point.get_x() <= point.get_max_x() && point.get_x() >= point.get_min_x() && point.get_y() <= point.get_max_y() && point.get_y() >= point.get_min_y();
    }

    public String toString() {
        return "(" + this.get_x() + "," + this.get_y() + ")";
    }
}
