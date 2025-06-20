package gold;

import java.io.*;
import java.util.*;

// 숨바꼭질 2
public class boj_12851 {
    static int N, K;
    static final int MAX = 100_001;
    static int[] time = new int[MAX];
    static int[] cnt = new int[MAX];

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(time, -1);

        q.offer(N);
        time[N] = 0;
        cnt[N] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (next < 0 || next >= MAX) continue;

                if (time[next] == -1) {
                    time[next] = time[cur] + 1;
                    cnt[next] = cnt[cur];
                    q.offer(next);
                } else if (time[next] == time[cur] + 1) {
                    cnt[next] += cnt[cur];
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
        System.out.println(cnt[K]);
    }
}