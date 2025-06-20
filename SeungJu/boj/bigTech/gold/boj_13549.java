package gold;

import java.io.*;
import java.util.*;

// 숨바꼭질 3
public class boj_13549 {
    static int N, K;
    static final int MAX = 100_001;
    static int[] time = new int[MAX];

    static void bfs() {
        Deque<Integer> dQ = new ArrayDeque<>();
        Arrays.fill(time, -1);

        dQ.offer(N);
        time[N] = 0;

        while (!dQ.isEmpty()) {
            int cur = dQ.poll();

            if (cur * 2 < MAX && (time[cur * 2] == -1 || time[cur * 2] > time[cur])) {
                time[cur * 2] = time[cur];
                dQ.offerFirst(cur * 2);
            }

            for (int next : new int[]{cur - 1, cur + 1}) {
                if (next < 0 || next >= MAX) continue;
                if (time[next] == -1 || time[next] > time[cur] + 1) {
                    time[next] = time[cur] + 1;
                    dQ.offerLast(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(time[K]);
    }
}
