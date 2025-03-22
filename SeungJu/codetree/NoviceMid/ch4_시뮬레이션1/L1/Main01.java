package ch4_시뮬레이션1.L1;

import java.util.Scanner;

// Time to Time
public class Main01 {
    public static void solution(int a, int b, int c, int d) {
        int hour = a, mins = b;
        int elapsedTime = 0;

        while (true) {
            if (hour == c && mins == d) break;
            elapsedTime++;
            mins++;

            if (mins == 60) {
                hour++;
                mins = 0;
            }
        }

        System.out.print(elapsedTime);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        solution(a, b, c, d);
    }
}