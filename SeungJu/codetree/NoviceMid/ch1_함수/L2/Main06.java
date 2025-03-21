package ch1_함수.L2;

import java.util.*;

// 함수를 이용한 윤년 판별
public class Main06 {
    public static boolean leapYear(int n) {
        if (n % 4 == 0) {
            if (n % 100 == 0 && n % 400 != 0) return false;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int y = sc.nextInt();

        System.out.println(leapYear(y));
    }
}
