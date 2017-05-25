package com.toi.imagehotspot.geometry;

/**
 * Created by zqi2 on 25/5/17.
 */

public class Point {
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(float x, float y) {
        this.x = (int) (x * 10000);
        this.y = (int) (y * 10000);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }
}