package 완전탐색.모음사전;

class Solution2 {
    int ans = 0;
    int cnt = 0;
    String[] alpha = {"A", "E", "I", "O", "U"};

    public void dfs(String cur, String target) {
        if (cur.equals(target)) {
            ans = cnt;
            return;
        }

        if (cur.length() == 5) return;

        for (int i = 0; i < 5; i++) {
            cnt++;
            dfs(cur + alpha[i], target);
        }
    }

    public int solution(String word) {
        dfs("", word);

        return ans;
    }
}