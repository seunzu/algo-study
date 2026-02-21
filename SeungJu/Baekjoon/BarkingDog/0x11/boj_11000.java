package greedy;

import java.io.*;
import java.util.*;

// 강의실 배정
public class boj_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int s = arr[i][0];
            int e = arr[i][1];

            if (!pQ.isEmpty() && pQ.peek() <= s) pQ.poll();

            pQ.add(e);
        }

        System.out.println(pQ.size());
    }
}
