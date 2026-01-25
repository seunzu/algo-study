package 완전탐색.피로도;

class Solution {
    static int n;
    static boolean[] visited;
    static int max = 0;

    public void dfs(int k, int[][] dungeons, int cnt) {
        max = Math.max(max, cnt);

        for (int i = 0; i < n; i++) {
            int need = dungeons[i][0];
            int use = dungeons[i][1];

            if (!visited[i] && k >= need) {
                visited[i] = true;
                dfs(k - use, dungeons, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new boolean[n];

        dfs(k, dungeons, 0);

        return max;
    }
}