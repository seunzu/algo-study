package silver;

import java.io.*;
import java.util.*;

// 아시아 정보올림피아드
class Student implements Comparable<Student> {
    int countryNum, studentNum, score;

    public Student(int countryNum, int studentNum, int score) {
        this.countryNum = countryNum;
        this.studentNum = studentNum;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return o.score - this.score;
    }
}

public class boj_2535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<>();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int countryNum = Integer.parseInt(st.nextToken());
            int studentNum = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            students.add(new Student(countryNum, studentNum, score));
        }

        Collections.sort(students);

        Map<Integer, Integer> HM = new HashMap<>();
        int awarded = 0;

        for (Student s : students) {
            int cnt = HM.getOrDefault(s.countryNum, 0);
            if (cnt >= 2) continue;

            sb.append(s.countryNum).append(" ").append(s.studentNum).append("\n");
            HM.put(s.countryNum, cnt + 1);
            awarded++;

            if (awarded == 3) break;
        }

        System.out.println(sb);
    }
}
