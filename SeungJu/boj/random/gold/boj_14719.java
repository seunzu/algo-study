package gold;

import java.io.*;
import java.util.*;

// 빗물
public class boj_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] height = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 1; i < W - 1; i++) {
            int lt = 0, rt = 0;

            for (int j = 0; j < i; j++) {
                lt = Math.max(height[j], lt);
            }

            for (int j = i + 1; j < W; j++) {
                rt = Math.max(height[j], rt);
            }

            if (height[i] < lt && height[i] < rt) {
                answer += Math.min(lt, rt) - height[i];
            }
        }

        System.out.println(answer);
    }
}
