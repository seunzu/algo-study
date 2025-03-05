import java.util.*;

// 배열
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] works = new int[100];
        int day = 0;

        for (int i = 0; i < progresses.length; i++) {
            int require = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            if (require > day) day = require;
            works[day]++;
        }

        for (int n : works) {
            if (n != 0) {
                answer.add(n);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}