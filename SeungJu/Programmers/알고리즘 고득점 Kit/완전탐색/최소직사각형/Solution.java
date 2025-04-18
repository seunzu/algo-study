package 완전탐색.최소직사각형;

import java.util.*;

public class Solution {
    public int solution(int[][] sizes) {
        int length = 0, height = 0;

        for (int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        return length * height;
    }
}