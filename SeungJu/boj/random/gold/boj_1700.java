package gold;

import java.io.*;
import java.util.*;

// 멀티탭 스케줄링
public class boj_1700 {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            int cur = arr[i];

            if (set.contains(cur)) continue;

            if (set.size() < N) {
                set.add(cur);
                continue;
            }

            int target = -1;
            int farthest = -1;
            for (int s : set) {
                int next = Integer.MAX_VALUE;
                for (int j = i + 1; j < K; j++) {
                    if (arr[j] == s) {
                        next = j;
                        break;
                    }
                }

                if (next > farthest) {
                    farthest = next;
                    target = s;
                }
            }

            set.remove(target);
            set.add(cur);
            cnt++;
        }

        System.out.println(cnt);
    }
}
