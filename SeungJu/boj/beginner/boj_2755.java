import java.io.*;
import java.util.*;

// 이번학기 평점은 몇점?
public class boj_2755 {
    public static double getScore(String grade) {
        switch (grade) {
            case "A+": return 4.3;
            case "A0": return 4.0;
            case "A-": return 3.7;
            case "B+": return 3.3;
            case "B0": return 3.0;
            case "B-": return 2.7;
            case "C+": return 2.3;
            case "C0": return 2.0;
            case "C-": return 1.7;
            case "D+": return 1.3;
            case "D0": return 1.0;
            case "D-": return 0.7;
            default:   return 0.0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        double totalScore = 0.0;
        double totalCredit = 0.0;

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            double score = getScore(grade);
            totalScore += credit * score;
            totalCredit += credit;
        }

        double avg = totalScore / totalCredit;
        System.out.printf("%.2f\n", avg);
    }
}
