package ch1_함수.L4;

import java.util.Scanner;

// 함수를 이용한 부분 문자열의 위치 구하기
public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.next();
        String pattern = sc.next();

        System.out.println(text.indexOf(pattern));
    }
}
