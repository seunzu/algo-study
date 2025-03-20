package ch3_정렬.L1;

import java.util.*;

// 문자열 정렬
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        char[] arr = s.toCharArray();

        Arrays.sort(arr);
        System.out.println(arr);
    }
}