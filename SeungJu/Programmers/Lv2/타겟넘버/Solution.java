package 타겟넘버;

class Solution {
    public int dfs(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {
            return sum == target ? 1 : 0;
        }

        int plus = dfs(numbers, target, depth + 1, sum + numbers[depth]);
        int minus = dfs(numbers, target, depth + 1, sum - numbers[depth]);

        return plus + minus;
    }

    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
}