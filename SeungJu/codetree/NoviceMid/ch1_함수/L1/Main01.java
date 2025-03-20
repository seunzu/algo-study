package ch1_함수.L1;

// 별을 찍는 것을 5번 반복하기
public class Main01 {
    public static void print5Stars() {
        for (int i = 0; i < 10; i++)
            System.out.print("*");
        System.out.println();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            print5Stars();
    }
}