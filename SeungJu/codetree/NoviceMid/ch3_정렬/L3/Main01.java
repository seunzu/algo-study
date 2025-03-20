package ch3_정렬.L3;

import java.util.*;

// 키를 기준으로 정렬
class User implements Comparable<User>{
    String name;
    int height;
    int weight;

    public User(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(User o) {
        if (this.height != o.height) return this.height - o.height;
        return this.weight - o.weight;
    }

    public void userInfo() {
        System.out.println(name + " " + height + " " + weight);
    }
}

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<User> users = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            users.add(new User(name, height, weight));
        }

        Collections.sort(users);
        for (User u : users) {
            u.userInfo();
        }
    }
}