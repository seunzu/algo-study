import java.io.*;
import java.util.*;

// 주사위 네개
public class boj_2484 {
    public static int getPrize(int[] arr) {
        Map<Integer, Integer> HM = new HashMap<>();
        for (int i : arr) {
            HM.put(i, HM.getOrDefault(i, 0) + 1);
        }

        int prize = 0;

        if (HM.size() == 1) {
            int n = arr[0];
            prize = 50000 + n * 5000;
        } else if (HM.size() == 2) {
            for (int k : HM.keySet()) {
                if (HM.get(k) == 3) {
                    prize = 10000 + k * 1000;
                    break;
                }
            }

            if (prize == 0) {
                int[] pairs = new int[2];
                int i = 0;
                for (int k : HM.keySet()) {
                    pairs[i++] = k;
                }
                prize = 2000 + pairs[0] * 500 + pairs[1] * 500;
            }
        } else if (HM.size() == 3) {
            for (int k : HM.keySet()) {
                if (HM.get(k) == 2) {
                    prize = 1000 + k * 100;
                    break;
                }
            }
        } else {
            int max = Arrays.stream(arr).max().getAsInt();
            prize = max * 100;
        }

        return prize;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int maxPrize = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[4];
            for (int j = 0; j < 4; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int prize = getPrize(arr);
            maxPrize = Math.max(maxPrize, prize);
        }

        System.out.println(maxPrize);
    }
}