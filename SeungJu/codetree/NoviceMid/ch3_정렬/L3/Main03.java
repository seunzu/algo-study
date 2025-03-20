package ch3_정렬.L3;

import java.util.*;

// 총점 비교
class Student implements Comparable<Student>{
    String name;
    int score1;
    int score2;
    int score3;

    public Student(String name, int score1, int score2, int score3) {
        this.name = name;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    @Override
    public int compareTo(Student o) {
        return (this.score1 + this.score2 + this.score3) - (o.score1 + o.score2 + o.score3);
    }

    public void studentInfo() {
        System.out.println(name + " " + score1 + " " + score2 + " " + score3);
    }
}

public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score1 = sc.nextInt();
            int score2 = sc.nextInt();
            int score3 = sc.nextInt();
            students.add(new Student(name, score1, score2, score3));
        }

        Collections.sort(students);
        for (Student s : students) s.studentInfo();
    }
}