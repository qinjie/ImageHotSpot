package com.toi.imagehotspot;

import com.toi.imagehotspot.geometry.Point;
import com.toi.imagehotspot.geometry.Rectangle;

/**
 * Created by zqi2 on 25/5/17.
 */

public class Hotspot {

    public static final int NONE = 0;
    public static final int HAND_LEFT = 1;
    public static final int HAND_RIGHT = 2;
    public static final int FEET = 3;
    public static final int TUMMY_BACK = 4;
    public static final int EYE_LEFT = 5;
    public static final int EYE_RIGHT = 6;
    public static final int RESPIRATORY = 7;
    public static final int ORAL = 8;

    public static String hotspotName(int type) {
        switch (type) {
            case HAND_LEFT:
            case HAND_RIGHT:
                return "HAND";
            case FEET:
                return "FEET";
            case TUMMY_BACK:
                return "TUMMY BACK";
            case EYE_LEFT:
            case EYE_RIGHT:
                return "EYE";
            case RESPIRATORY:
                return "RESPIRATORY";
            case ORAL:
                return "ORAL";
            default:
                return "None";
        }
    }

    public static Rectangle handLeft = new Rectangle(new Point(0f, 0.3f), new Point(0.25f, 0.55f));
    public static Rectangle handRight = new Rectangle(new Point(0.75f, 0.3f), new Point(1.0f, 0.55f));
    public static Rectangle feet = new Rectangle(new Point(0.2f, 0.75f), new Point(0.8f, 1.0f));
    public static Rectangle tummyBack = new Rectangle(new Point(0.34f, 0.53f), new Point(0.65f, 0.65f));

    public static Rectangle eyeLeft = new Rectangle(new Point(0.32f, 0.18f), new Point(0.43f, 0.28f));
    public static Rectangle eyeRight = new Rectangle(new Point(0.53f, 0.18f), new Point(0.67f, 0.28f));
    public static Rectangle respiratory = new Rectangle(new Point(0.43f, 0.26f), new Point(0.53f, 0.33f));
    public static Rectangle oral = new Rectangle(new Point(0.37f, 0.33f), new Point(0.59f, 0.40f));

    public static int getHotspot(Point point) {
        if (handLeft.contains(point)) return HAND_LEFT;
        if (handRight.contains(point)) return HAND_RIGHT;
        if (feet.contains(point)) return FEET;
        if (tummyBack.contains(point)) return TUMMY_BACK;
        if (eyeLeft.contains(point)) return EYE_LEFT;
        if (eyeRight.contains(point)) return EYE_RIGHT;
        if (respiratory.contains(point)) return RESPIRATORY;
        if (oral.contains(point)) return ORAL;

        return NONE;
    }
}
