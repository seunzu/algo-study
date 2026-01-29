package 그리디.섬연결하기;

import java.util.*;

class Solution {
    static int[] unf;

    static int find(int v) {
        if (unf[v] == v) return v;
        return unf[v] = find(unf[v]);
    }

    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fb] = fa;
    }

    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) unf[i] = i;

        int ans = 0;
        int cnt = 0;

        for (int[] c : costs) {
            int a = c[0];
            int b = c[1];
            int cost = c[2];

            if (find(a) != find(b)) {
                union(a, b);
                ans += cost;
                cnt++;

                if (cnt == n - 1) break;
            }
        }

        return ans;
    }
}