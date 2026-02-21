package bfs;

import java.io.*;
import java.util.*;

// 상범 빌딩
class Building {
    int z, x, y, time;

    public Building(int z, int x, int y, int time) {
        this.z = z;
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class boj_6593 {
    static int L, R, C;
    static char[][][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static int bfs(int z, int x, int y) {
        Queue<Building> q = new LinkedList<>();
        q.offer(new Building(z, x, y, 0));
        visited[z][x][y] = true;

        while (!q.isEmpty()) {
            Building cur = q.poll();

            if (map[cur.z][cur.x][cur.y] == 'E') {
                return cur.time;
            }

            for (int dir = 0; dir < 6; dir++) {
                int nz = cur.z + dz[dir];
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nz < 0 || nx < 0 || ny < 0 || nz >= L || nx >= R || ny >= C) continue;
                if (!visited[nz][nx][ny] && map[nz][nx][ny] != '#') {
                    visited[nz][nx][ny] = true;
                    q.offer(new Building(nz, nx, ny, cur.time + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            map = new char[L][R][C];
            visited = new boolean[L][R][C];

            int startZ = 0, startX = 0, startY = 0;

            for (int z = 0; z < L; z++) {
                for (int x = 0; x < R; x++) {
                    String line = br.readLine();
                    for (int y = 0; y < C; y++) {
                        map[z][x][y] = line.charAt(y);
                        if (map[z][x][y] == 'S') {
                            startZ = z;
                            startX = x;
                            startY = y;
                        }
                    }
                }
                br.readLine();
            }

            int result = bfs(startZ, startX, startY);

            if (result == -1) System.out.println("Trapped!");
            else System.out.printf("Escaped in %d minute(s).\n", result);
        }
    }
}
