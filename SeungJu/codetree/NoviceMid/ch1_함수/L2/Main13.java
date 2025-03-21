package ch1_함수.L2;

import java.util.*;

// 그 계절, 그 날
public class Main13 {
    public static boolean leapYear(int y) {
        if (y % 4 != 0) return false;
        if (y % 100 == 0 && y % 400 != 0) return false;
        return true;
    }

    public static boolean isValidDate(int y, int m, int d) {
        if (m < 1 || m > 12 || d < 1) return false;
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (leapYear(y)) days[2] = 29;
        return d <= days[m];
    }

    public static String getSeason(int m) {
        if (m >= 3 && m <= 5) return "Spring";
        else if (m >= 6 && m <= 8) return "Summer";
        else if (m >= 9 && m <= 11) return "Fall";
        else return "Winter";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();

        System.out.println(isValidDate(y, m, d) ? getSeason(m) : "-1");
    }
}