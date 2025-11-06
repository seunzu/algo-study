package DFSBFS.여행경로;

import java.util.*;

class Solution {
    static List<String> arr = new ArrayList<>();
    static boolean[] visited;

    public void dfs(int depth, String curr, String path, String[][] tickets) {
        if (depth == tickets.length) {
            arr.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(curr)) {
                visited[i] = true;
                dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(arr);
        return arr.get(0).split(" ");
    }
}