package ch1_함수.L2;

import java.util.*;

// 2021년 날짜의 유무
public class Main12 {
    public static boolean isValidDate(int m, int d) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (m < 1 || m > 12) return false;
        if (d < 1 || d > days[m]) return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int d = sc.nextInt();

        System.out.println(isValidDate(m, d) ? "Yes" : "No");
    }
}