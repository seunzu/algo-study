package 네트워크;

import java.util.*;

class Solution {
    boolean[] visited;

    public void dfs(int node, int[][] computers) {
        visited[node] = true;

        for (int i = 0; i < computers.length; i++) {
            if (i != node && computers[node][i] == 1 && !visited[i]) {
                dfs(i, computers);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                count++;
            }
        }

        return count;
    }
}