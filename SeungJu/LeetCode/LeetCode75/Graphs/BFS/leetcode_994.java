package LeetCode75.Graphs.BFS;

// Rotting Oranges
public class leetcode_994 {
    class Solution {
        int m, n;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        int bfs(int[][] grid, Queue<int[]> q, int fresh) {
            int minutes = 0;

            while (!q.isEmpty() && fresh > 0) {
                int size = q.size();

                for (int i = 0; i < size; i++) {
                    int[] cur = q.poll();

                    for (int d = 0; d < 4; d++) {
                        int nr = cur[0] + dr[d];
                        int nc = cur[1] + dc[d];

                        if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;

                        if (grid[nr][nc] != 1) continue;

                        grid[nr][nc] = 2;
                        fresh--;

                        q.offer(new int[]{nr,nc});
                    }
                }

                minutes++;
            }

            return fresh == 0 ? minutes : -1;
        }

        public int orangesRotting(int[][] grid) {
            m = grid.length;
            n = grid[0].length;

            Queue<int[]> q = new ArrayDeque<>();
            int fresh = 0;

            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (grid[r][c] == 2) {
                        q.offer(new int[]{r, c});
                    }

                    if (grid[r][c] == 1) fresh++;
                }
            }

            return bfs(grid, q, fresh);
        }
    }
}
