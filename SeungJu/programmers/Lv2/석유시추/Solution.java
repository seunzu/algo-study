package 석유시추;

import java.util.*;

class Solution {
    int n, m;
    int[][] land;
    boolean[][] visited;
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};

    public int bfs(int r, int c, int id) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;
        land[r][c] = id;

        int size = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (land[nr][nc] == 1 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        land[nr][nc] = id;
                        q.offer(new int[]{nr, nc});
                        size++;
                    }
                }
            }
        }

        return size;
    }

    public int solution(int[][] land) {
        this.land = land;
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];

        Map<Integer, Integer> HM = new HashMap<>();
        int id = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int size = bfs(i, j, id);
                    HM.put(id, size);
                    id++;
                }
            }
        }

        int max = 0;
        for (int col = 0; col < m; col++) {
            Set<Integer> set = new HashSet<>();
            int sum = 0;

            for (int row = 0; row < n; row++) {
                int cur = land[row][col];

                if (cur > 1 && !set.contains(cur)) {
                    sum += HM.get(cur);
                    set.add(cur);
                }
            }

            max = Math.max(max, sum);
        }

        return max;
    }
}