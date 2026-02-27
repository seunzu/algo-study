package LeetCode75.Stack;

// Asteroid Collision
public class leetcode_735 {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();

            for (int a : asteroids) {
                boolean destroyed = false;

                while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                    if (stack.peek() < -a) stack.pop();
                    else if (stack.peek() == -a) {
                        stack.pop();
                        destroyed = true;
                        break;
                    } else {
                        destroyed = true;
                        break;
                    }
                }

                if (!destroyed) stack.push(a);
            }

            int n = stack.size();
            int[] result = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                result[i] = stack.pop();
            }

            return result;
        }
    }
}
