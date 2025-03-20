package ch3_정렬.L2;

import java.util.*;

// 폭탄 해제
class User {
    char codeName;
    int score;

    public User(char codeName, int score) {
        this.codeName = codeName;
        this.score = score;
    }

    public void userInfo() {
        System.out.println(codeName + " " + score);
    }
}

public class Main04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        User[] users = new User[5];
        for (int i = 0; i < 5; i++) {
            char codeName = sc.next().charAt(0);
            int score = sc.nextInt();
            users[i] = new User(codeName, score);
        }

        User min = users[0];

        for (int i = 1; i < 5; i++) {
            if (users[i].score < min.score) {
                min = users[i];
            }
        }

        min.userInfo();
    }
}