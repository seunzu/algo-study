package 내적;

class Solution {
    public int solution(int[] a, int[] b) {
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            total += a[i] * b[i];
        }

        return total;
    }
}
