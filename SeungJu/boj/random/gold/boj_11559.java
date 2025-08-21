package gold;

import java.io.*;
import java.util.*;

// Puyo Puyo
class Puyo {
    int x, y;
    char color;

    public Puyo(int x, int y, char color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}

public class boj_11559 {
    static char[][] map = new char[12][6];
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean bfs(int x, int y) {
        Queue<Puyo> q = new LinkedList<>();
        List<Puyo> toRemove = new ArrayList<>();

        visited[x][y] = true;
        char color = map[x][y];
        q.offer(new Puyo(x, y, color));
        toRemove.add(new Puyo(x, y, color));

        while (!q.isEmpty()) {
            Puyo cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
                if (!visited[nx][ny] && map[nx][ny] == color) {
                    visited[nx][ny] = true;
                    q.offer(new Puyo(nx, ny, color));
                    toRemove.add(new Puyo(nx, ny, color));
                }
            }
        }

        if (toRemove.size() >= 4) {
            for (Puyo p : toRemove) {
                map[p.x][p.y] = '.';
            }
            return true;
        }

        return false;
    }

    static void applyGravity() {
        for (int col = 0; col < 6; col++) {
            List<Character> list = new ArrayList<>();

            for (int row = 11; row >= 0; row--) {
                if (map[row][col] != '.') {
                    list.add(map[row][col]);
                }
            }

            for (int row = 11; row >= 0; row--) {
                if (!list.isEmpty()) {
                    map[row][col] = list.remove(0);
                } else map[row][col] = '.';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int cnt = 0;
        while (true) {
            boolean exploded = false;
            visited = new boolean[12][6];

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.' && !visited[i][j]) {
                        if (bfs(i, j)) exploded = true;
                    }
                }
            }

            if (!exploded) break;

            applyGravity();
            cnt++;
        }

        System.out.println(cnt);
    }
}
