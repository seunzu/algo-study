package gold.g2;

import java.io.*;
import java.util.*;

// 선분 교차 2
public class boj_17387 {
    static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static long ccw(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y)
                - (b.y - a.y) * (c.x - a.x);
    }

    static boolean overlap(Point a, Point b, Point c, Point d) {
        return Math.max(a.x, b.x) >= Math.min(c.x, d.x)
                && Math.max(c.x, d.x) >= Math.min(a.x, b.x)
                && Math.max(a.y, b.y) >= Math.min(c.y, d.y)
                && Math.max(c.y, d.y) >= Math.min(a.y, b.y);
    }

    static boolean isCross(Point A, Point B, Point C, Point D) {
        long ab1 = ccw(A, B, C);
        long ab2 = ccw(A, B, D);
        long cd1 = ccw(C, D, A);
        long cd2 = ccw(C, D, B);

        if (ab1 == 0 && ab2 == 0 && cd1 == 0 && cd2 == 0) {
            return overlap(A, B, C, D);
        }

        return (ab1 <= 0 && ab2 >= 0 || ab1 >= 0 && ab2 <= 0)
                && (cd1 <= 0 && cd2 >= 0 || cd1 >= 0 && cd2 <= 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Point A = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point B = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        Point C = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point D = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        System.out.println(isCross(A, B, C, D) ? 1 : 0);
    }
}
