package priorityQueue;

import java.io.*;
import java.util.*;

// 컵라면
public class boj_1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int deadline = arr[i][0];
            int ramen = arr[i][1];

            pQ.add(ramen);

            if (pQ.size() > deadline) pQ.poll();
        }

        long total = 0;
        while (!pQ.isEmpty()) total += pQ.poll();

        System.out.println(total);
    }
}
