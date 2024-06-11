package basic;

import java.util.Scanner;

public class BOJ4299 {

    // AFC 윔블던
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int m = sc.nextInt();

        if ((s + m) % 2 != 0 || s < m) {
            System.out.println(-1);
        } else {
            System.out.printf("%d %d", (s + m) / 2, (s + m) / 2 - m);
        }
    }
}
