package ch4_시뮬레이션1.L1;

import java.util.Scanner;

// Date to Date
public class Main02 {
    public static void solution(int m1, int d1, int m2, int d2) {
        int month = m1, day = d1;
        int elapsedDays = 0;

        int[] nums = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        while (true) {
            if (month == m2 && day == d2) break;

            elapsedDays++;
            day++;

            if (day > nums[month]) {
                month++;
                day = 1;
            }
        }

        System.out.print(elapsedDays + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        solution(m1, d1, m2, d2);
    }
}