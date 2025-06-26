package gold;

import java.io.*;
import java.util.*;

// 숨바꼭질 4
public class boj_13913 {
    static int N, K;
    static final int MAX = 100_001;
    static int[] time = new int[MAX];
    static int[] prev = new int[MAX];

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(time, -1);

        q.offer(N);
        time[N] = 0;
        prev[N] = -1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == K) return;

            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (next < 0 || next >= MAX) continue;

                if (time[next] == -1) {
                    time[next] = time[cur] + 1;
                    prev[next] = cur;
                    q.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
        sb.append(time[K]).append("\n");

        Stack<Integer> stack = new Stack<>();
        for (int i = K; i != -1; i = prev[i]) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}
