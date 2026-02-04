package 나머지가1이되는수찾기;

class Solution {
    public int solution(int n) {
        int ans = 1;

        while (true) {
            if (n % ans == 1) break;
            ans++;
        }

        return ans;
    }
}