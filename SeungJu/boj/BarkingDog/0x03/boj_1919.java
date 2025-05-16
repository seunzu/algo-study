package array;

import java.io.*;

// 애너그램 만들기
public class boj_1919 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i : str1.toCharArray()) arr1[i - 97]++;
        for (int i : str2.toCharArray()) arr2[i - 97]++;

        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (arr1[i] - arr2[i] != 0) cnt += Math.abs(arr1[i] - arr2[i]);
        }
        System.out.println(cnt);
    }
}
