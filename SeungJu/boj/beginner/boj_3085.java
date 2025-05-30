import java.io.*;

// 사탕 게임
public class boj_3085 {
    static int N;
    static char[][] arr;

    public static void swap(int x1, int y1, int x2, int y2) {
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    public static int check() {
        int len = arr.length;
        int max = 1;

        for (int i = 0; i < len; i++) {
            int row = 1;
            for (int j = 1; j < len; j++) {
                if (arr[i][j] == arr[i][j - 1]) row++;
                else row = 1;
                max = Math.max(max, row);
            }
        }

        for (int j = 0; j < len; j++) {
            int col = 1;
            for (int i = 1; i < len; i++) {
                if (arr[i][j] == arr[i - 1][j]) col++;
                else col = 1;
                max = Math.max(max, col);
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) {
                    swap(i, j, i, j + 1);
                    max = Math.max(max, check());
                    swap(i, j, i, j + 1);
                }

                if (i + 1 < N) {
                    swap(i, j, i + 1, j);
                    max = Math.max(max, check());
                    swap(i, j, i + 1, j);
                }
            }
        }

        System.out.println(max);
    }
}
