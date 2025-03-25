import java.io.*;

// 팩토리얼
public class boj_10872 {
    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.print(factorial(n));
    }
}
