package oo.hide;


public class PointSet {
    Point[] set;

    public PointSet(int capacity) {
        set = new Point[capacity];
    }

    public PointSet() {
        this(10);
    }

    public void add(Point point) {
        if (!contains(point)) {
            if (size() == set.length) {
                Point[] temp = new Point[set.length * 2];
                for (int j = 0; j < set.length; j++) {
                    temp[j] = set[j];
                }
                set = temp;
            }
            int indexToAddPoint = size();  //according to the size of set, place new point as the last element of an array.
            set[indexToAddPoint] = point;
        }
    }

    public int size() {
        int count = 0;
        for (Point point : set) {
            if (point == null) {
                break;
            } else {
                count++;
            }
        }
        return count;
    }

    public boolean contains(Point point) {
        for (Point p : set) {
            if (point != null && point.equals(p)) {
                return true;
            }
        }
        return false;
    }

    public PointSet subtract(PointSet other) {
        PointSet subtractedSet = new PointSet();
        for (Point point : set) {
            if (other.contains(point)) {  //võrdleb, kas other arrays olev punkt(point) on olemas ka set arrays.
                continue;
            } else {
                subtractedSet.add(point);
            }
        }
        return subtractedSet;
    }

    public PointSet intersect(PointSet other) {
        PointSet intersectedSet = new PointSet();
        for (Point point : set) {
            if (other.contains(point)) {
                intersectedSet.add(point);
            }
        }
        return intersectedSet;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PointSet)) {
            return false;
        }
        PointSet other = (PointSet) o;

        for (Point point : set) {
            if (point != null && !other.contains(point)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < size(); i++) {
            if (i == size() - 1) {
                result += set[i];
            } else {
                result += set[i] + ", ";
            }

        }
        return result;
    }


    public static void main(String[] args) {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(1, 2);
        Point point3 = new Point(1, 1);
        Point point4 = new Point(2, 3);

        PointSet pointset = new PointSet();
        pointset.add(point1);
        pointset.add(point2);

        System.out.println(pointset.contains(point4));
        System.out.println(pointset.size());

        PointSet pointset2 = new PointSet();
        pointset2.add(point3);
        pointset2.add(point4);

        System.out.println(pointset);

        PointSet remainder = pointset.subtract(pointset2);
        System.out.println(remainder);
    }
}
