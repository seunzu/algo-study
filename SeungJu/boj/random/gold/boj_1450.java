package gold;

import java.io.*;
import java.util.*;

// 냅색문제
public class boj_1450 {
    static int N, C;
    static int[] arr;
    static List<Long> lt = new ArrayList<>();
    static List<Long> rt = new ArrayList<>();

    static void dfs(int start, int end, long sum, List<Long> list) {
        if (sum > C) return;
        if (start == end) {
            list.add(sum);
            return;
        }
        dfs(start + 1, end, sum, list);
        dfs(start + 1, end, sum + arr[start], list);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, N / 2, 0, lt);
        dfs(N / 2, N, 0, rt);

        Collections.sort(rt);

        long ans = 0;
        for (long x : lt) {
            long target = C - x;
            int l = 0, r = rt.size();
            while (l < r) {
                int mid = (l + r) / 2;
                if (rt.get(mid) <= target) l = mid + 1;
                else r = mid;
            }
            ans += l;
        }


        System.out.println(ans);
    }
}
