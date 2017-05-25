package com.toi.imagehotspot.geometry;

/**
 * Created by zqi2 on 25/5/17.
 */

public class Rectangle {
    public final Point start;
    public final Point end;

    public Rectangle(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public boolean contains(Point point) {
        return point.equals(Points.max(start, Points.min(end, point)));
    }
}