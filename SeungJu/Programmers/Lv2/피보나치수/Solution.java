package 피보나치수;

class Solution {
    public int fibo(int n) {
        if (n < 2) return n;
        return fibo(n - 1) + fibo(n - 2);
    }

    public int solution(int n) {
        int[] answer = new int[n + 1];
        answer[0] = 0;
        answer[1] = 1;

        for (int i = 2; i <= n; i++) {
            answer[i] = (answer[i - 1] + answer[i - 2]) % 1234567;
        }

        return answer[n];
    }
}