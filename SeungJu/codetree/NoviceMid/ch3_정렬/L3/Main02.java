package ch3_정렬.L3;

import java.util.*;

// 국영수 순이지
class Student implements Comparable<Student>{
    String name;
    int korean;
    int english;
    int math;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    @Override
    public int compareTo(Student o) {
        if (this.korean != o.korean) return o.korean - this.korean;
        if (this.english != o.english) return o.english - this.english;
        return o.math - this.math;
    }

    public void studentInfo() {
        System.out.println(name + " " + korean + " " + english + " " + math);
    }
}

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int korean = sc.nextInt();
            int english = sc.nextInt();
            int math = sc.nextInt();
            students.add(new Student(name, korean, english, math));
        }

        Collections.sort(students);
        for (Student s : students) s.studentInfo();
    }
}