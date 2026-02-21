package simulation;

import java.io.*;
import java.util.*;

// 감시
class CCTV {
    int type, x, y;

    public CCTV(int type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }
}

public class boj_15683 {
    static int N, M;
    static int min = Integer.MAX_VALUE;
    static int[][] office;
    static List<CCTV> cameras = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void dfs(int depth, int[][] office) {
        if (depth == cameras.size()) {
            min = Math.min(min, countBlindSpots(office));
            return;
        }

        CCTV cctv = cameras.get(depth);
        List<int[]> directions = getDirections(cctv.type);

        for (int[] direction : directions) {
            int[][] tempOffice = new int[N][M];
            for (int i = 0; i < N; i++) {
                System.arraycopy(office[i], 0, tempOffice[i], 0, M); // 사무실 상태 복사
            }

            for (int d : direction) {
                watch(cctv.x, cctv.y, d, tempOffice);
            }

            dfs(depth + 1, tempOffice);
        }
    }

    static void watch(int x, int y, int direction, int[][] office) {
        int nx = x;
        int ny = y;

        while (true) {
            nx += dx[direction];
            ny += dy[direction];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || office[nx][ny] == 6) break;
            if (office[nx][ny] == 0) office[nx][ny] = 7;
        }
    }

    static int countBlindSpots(int[][] office) {
        int blindSpots = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (office[i][j] == 0) {
                    blindSpots++;
                }
            }
        }
        return blindSpots;
    }

    static List<int[]> getDirections(int type) {
        List<int[]> directions = new ArrayList<>();

        if (type == 1) {
            directions.add(new int[]{0});
            directions.add(new int[]{1});
            directions.add(new int[]{2});
            directions.add(new int[]{3});
        } else if (type == 2) {
            directions.add(new int[]{0, 1});
            directions.add(new int[]{2, 3});
        } else if (type == 3) {
            directions.add(new int[]{0, 2});
            directions.add(new int[]{0, 3});
            directions.add(new int[]{1, 2});
            directions.add(new int[]{1, 3});
        } else if (type == 4) {
            directions.add(new int[]{0, 1, 2});
            directions.add(new int[]{0, 1, 3});
            directions.add(new int[]{1, 2, 3});
            directions.add(new int[]{0, 2, 3});
        } else if (type == 5) {
            directions.add(new int[]{0, 1, 2, 3});
        }

        return directions;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        office = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    cameras.add(new CCTV(office[i][j], i, j));
                }
            }
        }

        dfs(0, office);
        System.out.println(min);
    }
}