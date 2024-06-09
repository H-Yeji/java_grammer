package basic;

import java.util.Scanner;

public class BOJ15439 {

    // 베라의 패션
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(n * (n - 1));

        sc.close();
    }
}
