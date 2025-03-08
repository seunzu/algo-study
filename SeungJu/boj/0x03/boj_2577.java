package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 숫자의 개수
public class boj_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        String value = Integer.toString(a * b * c);

        int[] arr = new int[10];
        for (int i : value.toCharArray()) arr[i - 48]++; // '0'

        for (int i : arr) System.out.println(i);
    }
}
