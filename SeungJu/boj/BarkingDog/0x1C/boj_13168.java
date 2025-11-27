package floydWarshall;

import java.io.*;
import java.util.*;

// 내일로 여행
public class boj_13168 {
    static int N, R, M, K;
    static final double INF = 1_000_000_000;

    static double getRailCost(String type, double cost) {
        if (type.equals("Mugunghwa") || type.equals("ITX-Saemaeul") || type.equals("ITX-Cheongchun")) return 0;
        else if (type.equals("S-Train") || type.equals("V-Train")) return cost / 2.0;
        return cost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        Map<String, Integer> HM = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String name = st.nextToken();
            if (!HM.containsKey(name)) HM.put(name, HM.size());
        }

        M = Integer.parseInt(br.readLine());

        int[] travel = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            travel[i] = HM.get(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());

        double[][] normal = new double[N][N];
        double[][] rail = new double[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(normal[i], INF);
            Arrays.fill(rail[i], INF);
            normal[i][i] = 0;
            rail[i][i] = 0;
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            String s = st.nextToken();
            String e = st.nextToken();
            double cost = Double.parseDouble(st.nextToken());

            int a = HM.get(s);
            int b = HM.get(e);

            normal[a][b] = Math.min(normal[a][b], cost);
            normal[b][a] = Math.min(normal[b][a], cost);

            double railCost = getRailCost(type, cost);
            rail[a][b] = Math.min(rail[a][b], railCost);
            rail[b][a] = Math.min(rail[b][a], railCost);
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    normal[i][j] = Math.min(normal[i][j], normal[i][k] + normal[k][j]);
                    rail[i][j] = Math.min(rail[i][j], rail[i][k] + rail[k][j]);
                }
            }
        }

        double normalCost = 0;
        double railCost = R;
        for (int i = 0; i < M - 1; i++) {
            int from = travel[i];
            int to = travel[i + 1];

            normalCost += normal[from][to];
            railCost += rail[from][to];
        }

        System.out.println(railCost < normalCost ? "Yes" : "No");
    }
}