package array;

import java.io.*;

// 알파벳 개수
public class boj_10808 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[26];

        for (int i : s.toCharArray()) arr[i - 97]++; // 'a'

        for (int i : arr) System.out.print(i + " ");
    }
}
