package ch3_정렬.L3;

import java.util.*;

// 원점으로부터의 거리
class Distance {
    int x, y, index;

    public Distance(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }

    public int getManhattanDistance() {
        return Math.abs(x) + Math.abs(y);
    }
}

public class Main07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Distance> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points.add(new Distance(x, y, i + 1));
        }

        Collections.sort(points, (a, b) -> {
            int d1 = a.getManhattanDistance();
            int d2 = b.getManhattanDistance();

            if (d1 != d2) return d1 - d2;
            return a.index - b.index;
        });

        for (Distance p : points) System.out.println(p.index);
    }
}
