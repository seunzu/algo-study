package gold.g3;

import java.io.*;
import java.util.*;

// 두 배열의 합
public class boj_2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        long[] A = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        long[] B = new long[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Long.parseLong(st.nextToken());
        }

        List<Long> sumA = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                sumA.add(sum);
            }
        }

        List<Long> sumB = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                sumB.add(sum);
            }
        }

        Collections.sort(sumA);
        Collections.sort(sumB);

        int lt = 0;
        int rt = sumB.size() - 1;
        long cnt = 0;

        while (lt < sumA.size() && rt >= 0) {
            long sum = sumA.get(lt) + sumB.get(rt);

            if (sum == T) {
                long cntA = 0;
                long valueA = sumA.get(lt);
                while (lt < sumA.size() && sumA.get(lt) == valueA) {
                    cntA++;
                    lt++;
                }

                long cntB = 0;
                long valueB = sumB.get(rt);
                while (rt >= 0 && sumB.get(rt) == valueB) {
                    cntB++;
                    rt--;
                }

                cnt += cntA * cntB;
            } else if (sum < T) lt++;
            else rt--;
        }

        System.out.println(cnt);
    }
}
