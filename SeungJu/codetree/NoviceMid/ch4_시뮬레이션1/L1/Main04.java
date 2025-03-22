package ch4_시뮬레이션1.L1;

import java.util.Scanner;

// 요일 맞추기
public class Main04 {
    static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static int getDayNum(int m, int d) {
        int sum = 0;
        for (int i = 1; i < m; i++) sum += days[i];
        sum += d;
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        String[] weeks = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int day1 = getDayNum(m1, d1);
        int day2 = getDayNum(m2, d2);

        int diff = day2 - day1;
        int index = ((0 + diff) % 7 + 7) % 7;
        System.out.println(weeks[index]);
    }
}