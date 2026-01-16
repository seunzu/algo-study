package gold.g5;

import java.io.*;
import java.util.*;

// 다각형의 면적
public class boj_2166 {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points.add(new Point(x, y));
        }

        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < N; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % N);

            sum1 += (long) p1.x * p2.y;
            sum2 += (long) p1.y * p2.x;
        }

        double area = Math.abs(sum1 - sum2) / 2.0;
        System.out.printf("%.1f\n", area);
    }
}
