package ch3_정렬.L2;

import java.util.*;

// 사는 지역
class User {
    String name;
    String address;
    String region;

    public User (String name, String address, String region) {
        this.name = name;
        this.address = address;
        this.region = region;
    }

    public void userInfo() {
        System.out.printf("name %s\naddr %s\ncity %s", name, address, region);
    }
}
public class Main06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        User[] users = new User[n];

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String address = sc.next();
            String region = sc.next();
            users[i] = new User(name, address, region);
        }

        User maxUser = users[0];
        for (int i = 1; i < n; i++) {
            if (users[i].name.compareTo(maxUser.name) > 0) {
                maxUser = users[i];
            }
        }

        maxUser.userInfo();
    }
}