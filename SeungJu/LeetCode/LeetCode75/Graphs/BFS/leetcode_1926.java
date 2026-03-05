package LeetCode75.Graphs.BFS;

// Nearest Exit from Entrance in Maze
public class leetcode_1926 {
    class Solution {
        int m, n;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        int bfs(char[][] maze, int[] entrance) {
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{entrance[0], entrance[1], 0});

            maze[entrance[0]][entrance[1]] = '+';

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                int dist = cur[2];

                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;

                    if (maze[nr][nc] == '+') continue;

                    if (nr == 0 || nr == m-1 || nc == 0 || nc == n-1) {
                        return dist + 1;
                    }

                    maze[nr][nc] = '+';
                    q.offer(new int[]{nr, nc, dist + 1});
                }
            }

            return -1;
        }

        public int nearestExit(char[][] maze, int[] entrance) {
            m = maze.length;
            n = maze[0].length;

            return bfs(maze, entrance);
        }
    }
}
