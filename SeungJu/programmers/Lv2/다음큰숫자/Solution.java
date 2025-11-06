package 다음큰숫자;

class Solution {
    public int solution(int n) {
        int cnt = Integer.bitCount(n);
        int answer = n + 1;

        while (true) {
            if (cnt == Integer.bitCount(answer)) break;
            answer++;
        }

        return answer;
    }
}