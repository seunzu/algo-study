package DFSBFS.퍼즐조각채우기;

import java.util.*;

class Solution {
    static class Point implements Comparable<Point> {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Point o) {
            if (this.r == o.r) return this.c - o.c;
            return this.r - o.r;
        }
    }

    static int N;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    List<List<Point>> extractShapes(int[][] arr, int target) {
        visited = new boolean[N][N];
        List<List<Point>> shapes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] == target) {
                    shapes.add(bfs(arr, i, j, target));
                }
            }
        }
        return shapes;
    }

    List<Point> bfs(int[][] arr, int sr, int sc, int target) {
        Queue<Point> q = new ArrayDeque<>();
        List<Point> shape = new ArrayList<>();

        visited[sr][sc] = true;
        q.offer(new Point(sr, sc));
        shape.add(new Point(sr, sc));

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (visited[nr][nc] || arr[nr][nc] != target) continue;

                visited[nr][nc] = true;
                q.offer(new Point(nr, nc));
                shape.add(new Point(nr, nc));
            }
        }
        return shape;
    }

    void normalize(List<Point> shape) {
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;

        for (Point p : shape) {
            minR = Math.min(minR, p.r);
            minC = Math.min(minC, p.c);
        }

        for (Point p : shape) {
            p.r -= minR;
            p.c -= minC;
        }

        Collections.sort(shape);
    }

    List<Point> rotate(List<Point> shape) {
        List<Point> rotated = new ArrayList<>();
        for (Point p : shape) {
            rotated.add(new Point(p.c, -p.r));
        }
        return rotated;
    }

    boolean isSame(List<Point> a, List<Point> b) {
        if (a.size() != b.size()) return false;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).r != b.get(i).r || a.get(i).c != b.get(i).c) {
                return false;
            }
        }
        return true;
    }

    public int solution(int[][] game_board, int[][] table) {
        N = game_board.length;

        List<List<Point>> blanks = extractShapes(game_board, 0);
        List<List<Point>> puzzles = extractShapes(table, 1);

        boolean[] used = new boolean[puzzles.size()];
        int ans = 0;

        for (List<Point> b : blanks) {
            normalize(b);

            for (int i = 0; i < puzzles.size(); i++) {
                if (used[i]) continue;

                List<Point> puzzle = puzzles.get(i);
                if (puzzle.size() != b.size()) continue;

                List<Point> rotated = new ArrayList<>(puzzle);
                boolean matched = false;

                for (int r = 0; r < 4; r++) {
                    normalize(rotated);
                    if (isSame(b, rotated)) {
                        matched = true;
                        break;
                    }
                    rotated = rotate(rotated);
                }

                if (matched) {
                    used[i] = true;
                    ans += b.size();
                    break;
                }
            }
        }

        return ans;
    }
}