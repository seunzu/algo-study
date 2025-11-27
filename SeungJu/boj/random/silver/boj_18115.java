package silver;

import java.io.*;
import java.util.*;

// 카드 놓기
public class boj_18115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = N; i >= 1; i--) {
            int command = A[i];
            int card = N - i + 1;

            if (command == 1) dq.addFirst(card);
            else if (command == 2) {
                int temp = dq.pollFirst();
                dq.addFirst(card);
                dq.addFirst(temp);
            } else dq.addLast(card);
        }

        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst()).append(" ");
        }

        System.out.println(sb);
    }
}
