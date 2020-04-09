package com.koncheng.cluster;

import java.util.List;
import java.util.Map;

public abstract class AbstractClustering implements Clustering {
    public AbstractClustering(List<Point> points, int centerNumber) {
        this.points = points;
        this.centerNumber = centerNumber;
    }



    protected List<Point> points;
    protected int centerNumber;
    protected Map<Point, List<Point>> clustedPoints = null;

    @Override
    public void print() {
        if (clustedPoints != null) {
            for (Map.Entry<Point, List<Point>> entry : clustedPoints.entrySet()) {
                Point circle = entry.getKey();
                List<Point> points = entry.getValue();
                System.out.print("Point:");
                circle.print();
                System.out.println();
                for (Point point : points) {
                    System.out.print("    ");
                    point.print();
                    System.out.println();
                }
                System.out.println();
            }
        }
    }
}
