package array;

import java.io.*;
import java.util.*;

// 개수 세기
public class boj_10807 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int v = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i : arr) {
            if (v == i) cnt++;
        }
        System.out.println(cnt);
    }
}
