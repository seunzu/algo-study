package 최고의집합;

class Solution {
    public int[] solution(int n, int s) {
        if (s < n) return new int[]{-1};

        int[] answer = new int[n];
        int base = s / n;
        int rest = s % n;

        for (int i = 0; i < n; i++) {
            if (i < n - rest) answer[i] = base;
            else answer[i] = base + 1;
        }

        return answer;
    }
}
