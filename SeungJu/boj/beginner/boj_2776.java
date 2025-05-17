import java.io.*;
import java.util.*;

// 암기왕
public class boj_2776 {
    static boolean binarySearch(int[] arr, int target) {
        int lt = 0, rt = arr.length - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (arr[mid] == target) return true;
            else if (arr[mid] < target) lt = mid + 1;
            else rt = mid - 1;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] note1 = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                note1[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(note1);

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int target = Integer.parseInt(st.nextToken());
                sb.append(binarySearch(note1, target) ? "1\n" : "0\n");
            }
        }

        System.out.println(sb);
    }
}
