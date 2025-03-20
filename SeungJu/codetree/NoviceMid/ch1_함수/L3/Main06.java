package ch1_함수.L3;

import java.util.*;

// 2개 이상의 알파벳
public class Main06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        Set<Character> set = new HashSet<>();
        for (char c : A.toCharArray()) set.add(c);

        System.out.println(set.size() >= 2 ? "Yes" : "No");
    }
}