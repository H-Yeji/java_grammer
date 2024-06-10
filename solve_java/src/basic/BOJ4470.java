package basic;

import java.util.Scanner;

public class BOJ4470 {

    // 줄번호
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            System.out.printf("%d. %s\n", i + 1, s);
        }
    }
}
