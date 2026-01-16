package gold.g3;

import java.io.*;
import java.util.*;

// 소수의 연속합
public class boj_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] isNotPrime = new boolean[N + 1];

        List<Integer> arr = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (!isNotPrime[i]) {
                arr.add(i);
                for (int j = i * 2; j <= N; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        int p1 = 0, p2 = 0;
        int sum = 0;
        int cnt = 0;
        while (true) {
            if (sum >= N) sum -= arr.get(p1++);
            else if (p2 == arr.size()) break;
            else sum += arr.get(p2++);

            if (sum == N) cnt++;
        }

        System.out.println(cnt);
    }
}
