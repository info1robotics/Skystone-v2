package org.firstinspires.ftc.teamcode.autonomous.interpolation;

import org.firstinspires.ftc.teamcode.autonomous.interpolation.Point;

public class Segment {
    Point a, b;

    public Segment() {
        a = new Point();
        b = new Point();
    }

    public Segment(Point start, Point end) {
        this.a = start;
        this.b = end;
    }

    public double getLength() {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }
}
