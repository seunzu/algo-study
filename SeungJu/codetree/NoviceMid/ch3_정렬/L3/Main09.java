package ch3_정렬.L3;

import java.util.*;

class Student {
    int height, weight, index;

    public Student(int height, int weight, int index) {
        this.height = height;
        this.weight = weight;
        this.index = index;
    }

    public void studentInfo() {
        System.out.println(height + " " + weight + " " + index);
    }
}

public class Main09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            int weight = sc.nextInt();
            students.add(new Student(height, weight, i + 1));
        }

        Collections.sort(students, (s1, s2) -> {
            if (s1.height != s2.height) return s1.height - s2.height;
            return s2.weight - s1.weight;
        });

        for (Student s : students) s.studentInfo();
    }
}