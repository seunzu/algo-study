package 피로도;

class Solution {
    public static int max = 0;
    public static boolean[] visited;

    public void dfs(int k, int[][] dungeons, int count) {
        max = Math.max(max, count);

        for (int i = 0; i < dungeons.length; i++) {
            int need = dungeons[i][0];
            int use = dungeons[i][1];

            if (!visited[i] && k >= need) {
                visited[i] = true;
                dfs(k - use, dungeons, count + 1);
                visited[i] = false;
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return max;
    }
}