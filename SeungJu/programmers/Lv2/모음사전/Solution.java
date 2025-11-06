package 모음사전;

class Solution {
    int answer = 0;
    int count = 0;
    String[] alpha = {"A", "E", "I", "O", "U"};

    public void dfs(String cur, String target) {
        if (cur.equals(target)) {
            answer = count;
            return;
        }

        if (cur.length() == 5) return;

        for (int i = 0; i < 5; i++) {
            count++;
            dfs(cur + alpha[i], target);
        }
    }

    public int solution(String word) {
        dfs("", word);
        return answer;
    }
}