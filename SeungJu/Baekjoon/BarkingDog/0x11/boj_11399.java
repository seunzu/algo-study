package greedy;

import java.io.*;
import java.util.*;

// ATM
public class boj_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(P);

        int sum = 0;
        int total = 0;
        for (int p : P) {
            sum += p;
            total += sum;
        }

        System.out.println(total);
    }
}
