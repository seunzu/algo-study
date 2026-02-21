package platinum.p5;

import java.io.*;
import java.util.*;

// 백조의 호수
public class boj_3197 {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> swanQ = new LinkedList<>();
    static Queue<int[]> nextSwanQ = new LinkedList<>();
    static Queue<int[]> waterQ = new LinkedList<>();
    static Queue<int[]> nextWaterQ = new LinkedList<>();
    static int[] swan1, swan2;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean moveSwan() {
        while (!swanQ.isEmpty()) {
            int[] cur = swanQ.poll();

            if (cur[0] == swan2[0] && cur[1] == swan2[1]) return true;

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;

                if (map[nx][ny] == '.') swanQ.offer(new int[]{nx, ny});
                else if (map[nx][ny] == 'X') nextSwanQ.offer(new int[]{nx, ny});
            }
        }

        swanQ = nextSwanQ;
        nextSwanQ = new LinkedList<>();
        return false;
    }

    static void melt() {
        while (!waterQ.isEmpty()) {
            int[] cur = waterQ.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (map[nx][ny] == 'X') {
                    map[nx][ny] = '.';
                    nextWaterQ.offer(new int[]{nx, ny});
                }
            }
        }

        waterQ = nextWaterQ;
        nextWaterQ = new LinkedList<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        int cnt = 0;
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] != 'X') {
                    waterQ.offer(new int[]{i, j});
                }

                if (map[i][j] == 'L') {
                    if (cnt == 0) swan1 = new int[]{i, j};
                    else swan2 = new int[]{i, j};
                    cnt++;
                    map[i][j] = '.';
                }
            }
        }

        swanQ.offer(swan1);
        visited[swan1[0]][swan1[1]] = true;

        int day = 0;
        while (true) {
            if (moveSwan()) {
                System.out.println(day);
                return;
            }
            melt();
            day++;
        }
    }
}
