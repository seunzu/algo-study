package 방문길이;

import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();

        int x = 0, y = 0;
        int count = 0;

        Map<Character, int[]> direction = Map.of(
                'U', new int[]{0, 1},
                'D', new int[]{0, -1},
                'L', new int[]{-1, 0},
                'R', new int[]{1, 0}
        );

        for (char d : dirs.toCharArray()) {
            int[] move = direction.get(d);
            int nx = x + move[0];
            int ny = y + move[1];

            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;

            String path1 = x + "," + y + "→" + nx + "," + ny;
            String path2 = nx + "," + ny + "→" + x + "," + y;

            if (!visited.contains(path1) && !visited.contains(path2)) {
                visited.add(path1);
                visited.add(path2);
                count++;
            }

            x = nx;
            y = ny;
        }

        return count;
    }
}