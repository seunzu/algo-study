package twoPointer;

import java.io.*;
import java.util.*;

// List of Unique Numbers
public class boj_13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[100001];

        long cnt = 0;
        int end = 0;
        for (int start = 0; start < N; start++) {
            while (end < N &&!visited[arr[end]]) {
                visited[arr[end]] = true;
                end++;
            }

            cnt += end - start;
            visited[arr[start]] = false;
        }

        System.out.println(cnt);
    }
}
