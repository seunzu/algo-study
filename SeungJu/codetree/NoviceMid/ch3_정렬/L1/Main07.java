package ch3_정렬.L1;

import java.util.*;

// 순서를 바꾸었을 때 같은 단어인지 판별하기
public class Main07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word1 = sc.next();
        String word2 = sc.next();

        if (word1.length() != word2.length()) {
            System.out.println("No");
            return;
        }

        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        System.out.println(Arrays.equals(arr1, arr2) ? "Yes": "No");
    }
}