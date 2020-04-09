package com.koncheng.cluster;

import java.util.Objects;

public class Point {
    double x;
    double y;

    public void print() {
        System.out.print("(" + x + ", " + y + ")");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
