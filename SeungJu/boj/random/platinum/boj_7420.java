package platinum;

import java.io.*;
import java.util.*;

// 맹독 장벽
public class boj_7420 {
    static int N, L;
    static Point[] points;

    static class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) return this.y - o.y;
            return this.x - o.x;
        }
    }

    static long ccw(Point p1, Point p2, Point p3) {
        return (long) (p2.x - p1.x) * (p3.y - p1.y) - (long) (p2.y - p1.y) * (p3.x - p1.x);
    }

    static double dist(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        points = new Point[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(points);

        List<Point> hull = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            while (hull.size() >= 2 &&
                    ccw(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(points[i]);
        }

        int t = hull.size() + 1;
        for (int i = N - 2; i >= 0; i--) {
            while (hull.size() >= t &&
                    ccw(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(points[i]);
        }
        hull.remove(hull.size() - 1);

        double perimeter = 0;
        for (int i = 0; i < hull.size(); i++) {
            Point p1 = hull.get(i);
            Point p2 = hull.get((i + 1) % hull.size());
            perimeter += dist(p1, p2);
        }

        perimeter += 2 * Math.PI * L;
        System.out.println(Math.round(perimeter));
    }
}
