package basic;

import java.util.Scanner;

public class BOJ5524 {

    // 입실 관리
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String st = sc.next();
            System.out.println(st.toLowerCase());
        }
    }
}
