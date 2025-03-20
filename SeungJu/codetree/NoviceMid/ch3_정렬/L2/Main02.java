package ch3_정렬.L2;

import java.util.Scanner;

// Next Level
class User {
    String id;
    int level;

    public User(String id, int level) {
        this.id = id;
        this.level = level;
    }

    public void printInfo() {
        System.out.println("user " + id + " lv " + level);
    }
}

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String id = sc.next();
        int level = sc.nextInt();

        User user1 = new User("codetree", 10);
        User user2 = new User(id, level);


    }
}