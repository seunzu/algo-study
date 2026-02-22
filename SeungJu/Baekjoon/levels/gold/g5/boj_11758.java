package gold.g5;

import java.io.*;
import java.util.*;

// CCW
public class boj_11758 {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static long ccw(Point p1, Point p2, Point p3) {
        return (long)(p2.x - p1.x) * (p3.y - p1.y)
                - (long)(p2.y - p1.y) * (p3.x - p1.x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Point[] points = new Point[3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }

        long ccw = ccw(points[0], points[1], points[2]);
        if (ccw > 0) System.out.println(1);
        else if (ccw < 0) System.out.println(-1);
        else System.out.println(0);
    }
}
