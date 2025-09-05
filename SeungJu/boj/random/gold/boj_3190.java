package gold;

import java.io.*;
import java.util.*;

// 뱀
public class boj_3190 {
    static int N, K, L;
    static int[][] board;
    static Map<Integer, Character> turns = new HashMap<>();
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int simulate() {
        Deque<int[]> snake = new ArrayDeque<>();
        snake.offer(new int[]{0, 0});
        int d = 0;
        int time = 0;

        while (true) {
            time++;
            int[] head = snake.peekLast();
            int nr = head[0] + dr[d];
            int nc = head[1] + dc[d];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N) break;
            for (int[] s : snake) {
                if (s[0] == nr && s[1] == nc) return time;
            }

            snake.addLast(new int[]{nr, nc});

            if (board[nr][nc] == 1) board[nr][nc] = 0;
            else snake.pollFirst();

            if (turns.containsKey(time)) {
                char c = turns.get(time);
                if (c == 'L') d = (d + 3) % 4;
                else d = (d + 1) % 4;
            }
        }
        return time;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            board[r][c] = 1;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            turns.put(X, C);
        }

        System.out.println(simulate());
    }
}
