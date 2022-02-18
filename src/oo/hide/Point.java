package oo.hide;

import java.util.Objects;

public class Point {

    private Integer x;
    private Integer y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        System.out.println(new Point(1, 2));
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }
        Point other = (Point) obj;
        return Objects.equals(x, other.x) && Objects.equals(y, other.y);
//        return x.equals(other.x) && y.equals(other.y);

    }
}
