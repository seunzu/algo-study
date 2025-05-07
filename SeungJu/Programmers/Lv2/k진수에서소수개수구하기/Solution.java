package k진수에서소수개수구하기;

class Solution {
    public boolean isPrime(long n) {
        if (n < 2) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public int solution(int n, int k) {
        int count = 0;
        String s = Integer.toString(n, k);
        String[] parts = s.split("0+");

        for (String part : parts) {
            if (part.isEmpty()) continue;
            long num = Long.parseLong(part);
            if (isPrime(num)) count++;
        }

        return count;
    }
}