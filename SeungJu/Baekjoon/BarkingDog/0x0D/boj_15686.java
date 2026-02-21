package simulation;

import java.io.*;
import java.util.*;

// 치킨 배달
public class boj_15686 {
    static int N, M;
    static int[][] graph;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> selected = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    static void dfs (int at, int depth) {
        if (depth == M) {
            int sum = 0;

            for (int[] h : houses) {
                int min = Integer.MAX_VALUE;
                for (int[] s : selected) {
                    int dist = Math.abs(h[0] - s[0]) + Math.abs(h[1] - s[1]);
                    min = Math.min(min, dist);
                }
                sum += min;
            }
            result = Math.min(result, sum);
            return;
        }

        for (int i = at; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            dfs(i + 1, depth + 1);
            selected.remove(selected.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                graph[i][j] = val;
                if (val == 1) houses.add(new int[]{i, j});
                else if (val == 2) chickens.add(new int[]{i, j});
            }
        }

        dfs(0, 0);
        System.out.println(result);
    }
}
