package DFSBFS.네트워크;

class Solution {
    public void dfs(int node, boolean[] visited, int[][] computers) {
        visited[node] = true;

        for (int i = 0; i < computers.length; i++) {
            if (i != node && computers[node][i] == 1 && !visited[i]) {
                dfs(i, visited, computers);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, computers);
                count++;
            }
        }

        return count;
    }
}