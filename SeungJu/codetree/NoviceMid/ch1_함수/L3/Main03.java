package ch1_함수.L3;

import java.util.*;

// palindrome 여부 판단하기
public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String reversed = new StringBuilder(input).reverse().toString();

        System.out.println(input.equals(reversed) ? "Yes" : "No");
    }
}