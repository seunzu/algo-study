package gold;

import java.io.*;
import java.util.*;

// 나무 재테크
public class boj_16235 {
    static int N, M, K;
    static int[][] A;
    static int[][] land;
    static Deque<Integer>[][] trees;

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    static void springAndSummer() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (trees[i][j].isEmpty()) continue;

                Deque<Integer> next = new ArrayDeque<>();
                int deadNutrient = 0;

                while (!trees[i][j].isEmpty()) {
                    int age = trees[i][j].pollFirst();
                    if (land[i][j] >= age) {
                        land[i][j] -= age;
                        next.addLast(age + 1);
                    } else {
                        deadNutrient += age / 2;
                    }
                }

                land[i][j] += deadNutrient;
                trees[i][j] = next;
            }
        }
    }

    static void fall() {
        List<int[]> births = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int age : trees[i][j]) {
                    if (age % 5 == 0) {
                        for (int d = 0; d < 8; d++) {
                            int ni = i + dx[d];
                            int nj = j + dy[d];
                            if (ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
                            births.add(new int[]{ni, nj});
                        }
                    }
                }
            }
        }

        for (int[] b : births) {
            trees[b[0]][b[1]].addFirst(1);
        }
    }

    static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                land[i][j] += A[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        land = new int[N][N];
        trees = new ArrayDeque[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                land[i][j] = 5;
                trees[i][j] = new ArrayDeque<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees[x][y].add(age);
        }

        // 초기 나무 나이 정렬
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!trees[i][j].isEmpty()) {
                    List<Integer> arr = new ArrayList<>(trees[i][j]);
                    Collections.sort(arr);
                    trees[i][j].clear();
                    for (int a : arr) trees[i][j].addLast(a);
                }
            }
        }

        while (K-- > 0) {
            springAndSummer();
            fall();
            winter();
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans += trees[i][j].size();
            }
        }

        System.out.println(ans);
    }
}