package LeetCode75.Graphs.DFS;

// Keys and Rooms
public class leetcode_841 {
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            boolean[] seen = new boolean[rooms.size()];
            Stack<Integer> stack = new Stack<>();

            seen[0] = true;
            stack.push(0);

            while (!stack.isEmpty()) {
                int node = stack.pop();

                for (int nei : rooms.get(node)) {
                    if (!seen[nei]) {
                        seen[nei] = true;
                        stack.push(nei);
                    }
                }
            }

            for (boolean v : seen) {
                if (!v) return false;
            }

            return true;
        }
    }
}
