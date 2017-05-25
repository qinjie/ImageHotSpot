package com.toi.imagehotspot.geometry;

/**
 * Created by zqi2 on 25/5/17.
 */

public class Points {
    // it's an utility class
    private Points() { throw new UnsupportedOperationException(); }

    public static Point min(Point p1, Point p2) {
        return new Point(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y));
    }

    public static Point max(Point p1, Point p2) {
        return new Point(Math.max(p1.x, p2.x), Math.max(p1.y, p2.y));
    }
}