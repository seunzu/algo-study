package ch1_함수.L2;

import java.util.*;

// 사칙연산 함수
public class Main08 {
    public static void solution(int a, char o, int c) {
        switch (o) {
            case '+':
                System.out.printf("%d %c %d = %d\n", a, o, c, a + c);
                break;
            case '-':
                System.out.printf("%d %c %d = %d\n", a, o, c, a - c);
                break;
            case '/':
                System.out.printf("%d %c %d = %d\n", a, o, c, a / c);
                break;
            case '*':
                System.out.printf("%d %c %d = %d\n", a, o, c, a * c);
                break;
            default:
                System.out.println("False");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        char o = sc.next().charAt(0);
        int c = sc.nextInt();

        solution(a, o, c);
    }
}