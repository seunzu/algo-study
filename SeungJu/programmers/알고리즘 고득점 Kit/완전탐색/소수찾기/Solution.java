package 완전탐색.소수찾기;

import java.util.*;

class Solution {
    static String numbers;
    static int n;
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;

    void dfs(String cur, int depth) {
        if (!cur.isEmpty()) set.add(Integer.parseInt(cur));

        if (depth == n) return;

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(cur + numbers.charAt(i), depth + 1);
            visited[i] = false;
        }
    }

    boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public int solution(String numbers) {
        this.numbers = numbers;
        n = numbers.length();

        visited = new boolean[n];
        dfs("", 0);

        int ans = 0;
        for (int s : set) {
            if (isPrime(s)) ans++;
        }

        return ans;
    }
}