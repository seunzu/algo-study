package 충돌위험찾기;

import java.util.*;

class Solution {
    static class Robot {
        int r, c;
        int idx;
        int[] route;
        boolean finished;

        Robot(int startR, int startC, int[] route) {
            this.r = startR;
            this.c = startC;
            this.route = route;
            this.idx = 1;
            this.finished = false;
        }
    }

    public int countCollision(Robot[] robots) {
        int[][] board = new int[101][101];

        for (Robot r : robots) {
            if (!r.finished) {
                board[r.r][r.c]++;
            }
        }

        int cnt = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (board[i][j] >= 2) cnt++;
            }
        }

        return cnt;
    }

    public int solution(int[][] points, int[][] routes) {
        int n = routes.length;
        Robot[] robots = new Robot[n];

        for (int i = 0; i < n; i++) {
            int start = routes[i][0] - 1;
            robots[i] = new Robot(
                    points[start][0],
                    points[start][1],
                    routes[i]
            );
        }

        int danger = 0;
        danger += countCollision(robots);

        while (true) {
            boolean active = false;

            for (Robot r : robots) {
                if (r.finished) continue;
                active = true;

                int target = r.route[r.idx] - 1;
                int tr = points[target][0];
                int tc = points[target][1];

                if (r.r != tr) {
                    r.r += (tr > r.r) ? 1 : -1;
                } else if (r.c != tc) {
                    r.c += (tc > r.c) ? 1 : -1;
                }

                if (r.r == tr && r.c == tc) r.idx++;
            }

            if (!active) break;

            danger += countCollision(robots);

            for (Robot r : robots) {
                if (!r.finished && r.idx == r.route.length) {
                    r.finished = true;
                }
            }
        }

        return danger;
    }
}