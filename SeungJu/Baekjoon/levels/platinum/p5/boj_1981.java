package platinum.p5;

import java.io.*;
import java.util.*;

// 배열에서 이동
public class boj_1981 {
    static int n;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static boolean canGo(int diff, int minVal, int maxVal) {
        for (int low = minVal; low + diff <= maxVal; low++) {
            int high = low + diff;

            if (arr[0][0] < low || arr[0][0] > high) continue;

            if (bfs(low, high)) return true;
        }

        return false;
    }

    static boolean bfs(int low, int high) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        visited[0][0] = true;
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == n - 1 && y == n - 1) return true;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (!visited[nx][ny] && arr[nx][ny] >= low && arr[nx][ny] <= high) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        
        int minVal = 200, maxVal = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                minVal = Math.min(minVal, arr[i][j]);
                maxVal = Math.max(maxVal, arr[i][j]);
            }
        }

        int lt = 0;
        int rt = maxVal - minVal;
        int answer = rt;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (canGo(mid, minVal, maxVal)) {
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }

        System.out.println(answer);
    }
}