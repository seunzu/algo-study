package deque;

import java.io.*;
import java.util.*;

// 회전하는 큐
public class boj_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int target : arr) {
            int targetIdx = deque.indexOf(target);
            int halfIdx = deque.size() / 2;

            if (targetIdx <= halfIdx) {
                for (int i = 0; i < targetIdx; i++) {
                    deque.offerLast(deque.pollFirst());
                    cnt++;
                }
            } else {
                for (int i = 0; i < deque.size() - targetIdx; i++) {
                    deque.offerFirst(deque.pollLast());
                    cnt++;
                }
            }

            deque.pollFirst();
        }

        System.out.println(cnt);
    }
}