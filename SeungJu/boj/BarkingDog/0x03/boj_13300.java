package array;

import java.io.*;
import java.util.*;

// 방 배정
public class boj_13300 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[2][6];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken()) - 1;
            arr[gender][grade]++;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                if (arr[i][j] > 0) {
                    cnt += (arr[i][j] + k - 1) / k;
                }
            }
        }
        System.out.println(cnt);
    }
}
