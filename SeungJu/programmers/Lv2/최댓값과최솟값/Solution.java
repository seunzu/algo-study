package 최댓값과최솟값;

public class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int max = Integer.parseInt(arr[0]);
        int min = max;

        for (int i = 1; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i]);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return min + " " + max;
    }
}