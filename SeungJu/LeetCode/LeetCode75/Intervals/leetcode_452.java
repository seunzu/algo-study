package LeetCode75.Intervals;

// Minimum Number of Arrows to Burst Balloons
public class leetcode_452 {
    class Solution {
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, (a, b) -> {
                if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            });

            int arrows = 1;
            int lastEnd = points[0][1];

            for (int i = 1; i < points.length; i++) {
                if (points[i][0] <= lastEnd) continue;
                else {
                    arrows++;
                    lastEnd = points[i][1];
                }
            }

            return arrows;
        }
    }
}
