package 튜플;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] arr = s.split("\\},\\{");

        Arrays.sort(arr, Comparator.comparingInt(String::length));

        Set<Integer> set = new LinkedHashSet<>();
        for (String str : arr) {
            for (String num : str.split(",")) {
                set.add(Integer.parseInt(num));
            }
        }

        return set.stream().mapToInt(i -> i).toArray();
    }
}