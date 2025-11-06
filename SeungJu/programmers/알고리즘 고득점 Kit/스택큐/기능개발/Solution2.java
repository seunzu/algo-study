package 스택큐.기능개발;

import java.util.*;

// 스택/큐
class Solution2 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int require = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            if (!queue.isEmpty() && queue.peek() < require) {
                answer.add(queue.size());
                queue.clear();
            }

            queue.add(require);
        }

        if (!queue.isEmpty()) {
            answer.add(queue.size());
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}