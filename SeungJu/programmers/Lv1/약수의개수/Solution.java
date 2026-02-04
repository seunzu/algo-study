package 약수의개수;

class Solution {
    static int cntDivisors(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cnt++;
                if (i != n / i) cnt++;
            }
        }

        return cnt;
    }

    public int solution(int left, int right) {
        int ans = 0;

        for (int i = left; i <= right; i++) {
            int num = cntDivisors(i);
            if (num % 2 == 0) {
                ans += i;
            } else ans -= i;
        }

        return ans;
    }
}