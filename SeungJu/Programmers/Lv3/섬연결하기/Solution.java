package 섬연결하기;

import java.util.*;

class Solution {
    static int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }

    static void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        if (rootA < rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;
    }

    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int answer = 0;
        int edgeCount = 0;

        for (int[] edge : costs) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];

            if (find(parent, a) != find(parent, b)) {
                union(parent, a, b);
                answer += cost;
                edgeCount++;

                if (edgeCount == n - 1) break;
            }
        }

        return answer;
    }
}