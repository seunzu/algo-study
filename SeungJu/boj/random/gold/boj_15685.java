package gold;

import java.io.*;
import java.util.*;

// 드래곤 커브
public class boj_15685 {
    static int N;
    static boolean[][] map = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static void drawDragonCurve(int x, int y, int d, int g) {
        List<Integer> arr = new ArrayList<>();
        arr.add(d);

        for (int gen = 0; gen < g; gen++) {
            for (int i = arr.size() - 1; i >= 0; i--) {
                arr.add((arr.get(i) + 1) % 4);
            }
        }

        map[y][x] = true;
        for (int a : arr) {
            x += dx[a];
            y += dy[a];
            map[y][x] = true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            drawDragonCurve(x, y, d, g);
        }

        int cnt = 0;
        for (int y = 0; y < 100; y++) {
            for (int x = 0; x < 100; x++) {
                if (map[y][x] && map[y][x + 1] & map[y + 1][x] && map[y + 1][x + 1]) cnt++;
            }
        }

        System.out.println(cnt);
    }
}
