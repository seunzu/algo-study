package silver.s2;

import java.io.*;
import java.util.*;

// A -> B
public class boj_16953 {
    static int A, B;

    static int bfs() {
        Queue<Long> q = new LinkedList<>();
        q.offer((long) A);

        int cnt = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                long num = q.poll();

                if (num == B) return cnt;

                if (num * 2 <= B) q.offer(num * 2);
                if (num * 10 + 1 <= B) q.offer(num * 10 + 1);
            }
            cnt++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }
}
