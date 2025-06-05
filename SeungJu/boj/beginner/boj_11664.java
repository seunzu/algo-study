import java.io.*;
import java.util.*;

// 선분과 점
class Point {
    double x, y, z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    double distanceTo(Point p) {
        double dx = this.x - p.x;
        double dy = this.y - p.y;
        double dz = this.z - p.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    Point interpolate(Point to, double t) {
        return new Point(
                this.x + (to.x - this.x) * t,
                this.y + (to.y - this.y) * t,
                this.z + (to.z - this.z) * t
        );
    }
}

public class boj_11664 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Point A = new Point(
                Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken())
        );
        Point B = new Point(
                Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken())
        );
        Point C = new Point(
                Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken()),
                Double.parseDouble(st.nextToken())
        );

        double low = 0.0, high = 1.0;
        while (high - low > 1e-9) {
            double m1 = (2 * low + high) / 3;
            double m2 = (low + 2 * high) / 3;

            Point p1 = A.interpolate(B, m1);
            Point p2 = A.interpolate(B, m2);

            double d1 = p1.distanceTo(C);
            double d2 = p2.distanceTo(C);

            if (d1 > d2) low = m1;
            else high = m2;
        }

        Point closest = A.interpolate(B, (low + high) / 2);
        System.out.printf("%.10f\n", closest.distanceTo(C));
    }
}
