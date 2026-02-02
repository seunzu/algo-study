package 후보키;

import java.util.*;

class Solution {
    static List<Integer> arr;

    static boolean isMinimal(int mask) {
        for (int a : arr) {
            if ((a & mask) == a) return false;
        }
        return true;
    }

    static boolean isUnique(int mask, String[][] relation, int row, int col) {
        Set<String> set = new HashSet<>();

        for (int r = 0; r < row; r++) {
            StringBuilder sb = new StringBuilder();

            for (int c = 0; c < col; c++) {
                if ((mask & (1 << c)) != 0) {
                    sb.append(relation[r][c]).append("|");
                }
            }

            if (!set.add(sb.toString())) return false;
        }

        return true;
    }

    public int solution(String[][] relation) {
        int row = relation.length;
        int col = relation[0].length;

        arr = new ArrayList<>();
        for (int mask = 1; mask < (1 << col); mask++) {
            if (!isMinimal(mask)) continue;
            if (isUnique(mask, relation, row, col)) {
                arr.add(mask);
            }
        }

        return arr.size();
    }
}
